/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventorgrabber;

import orienteeringTools.ProgressBar;
import IofXml30.java.Id;
import IofXml30.java.Organisation;
import EventorApi.OrganisationList;
import EventorApi.Person;
import EventorApi.PersonList;
import EventorApi.EventList;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
//import IofXml30.java.OrganisationList;
//import IofXml30.java.PersonList;
import java.util.HashMap;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import orienteeringTools.InformationDialog;

/**
 *
 * @author shep
 */
public class EventorGrabber {
    
    public static final String ORG_SELECTION_DIALOG_STRING = "Select the Organisation from the list below...";
    public static final String STATE_ASSOCIATION_ORGANISATION_TYPE_ID = "2"; // State Associations are OrganisationTypeId = 2, clubs OrganisationTypeId = 3

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String[] myStringArray = {"OK","Cancel"};
        int goNoGo = InformationDialog.optionBox(myStringArray, "Click OK to start downloading statistics from Eventor...\nThis may take some time depending on your internet speed!", "Eventor Statistics Grabber Tool");
        
        if (goNoGo != 0){
            // Get outta here
            return;
        }
        
        try {                                
            // First get a list of organisations
            EventorApi.OrganisationList organisationList = EventorInterface.downloadOrganisations();
            
            HashMap<String,String> organisationMap = new HashMap();
            for (EventorApi.Organisation organisation : organisationList.getOrganisation()) {                
                if (organisation.getOrganisationTypeId().getContent().equals(STATE_ASSOCIATION_ORGANISATION_TYPE_ID))
                    organisationMap.put(organisation.getMediaName().getContent(), organisation.getOrganisationId().getContent());
            }            
            
            // Now offer the user to select one
            // State Associations are OrganisationTypeId = 2, clubs OrganisationTypeId = 3
            JList list = new JList(organisationMap.keySet().toArray());
            list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            int selection = JOptionPane.showConfirmDialog(null, new JScrollPane(list), ORG_SELECTION_DIALOG_STRING, JOptionPane.OK_CANCEL_OPTION);

            if (selection == JOptionPane.CANCEL_OPTION) {
                // Code to use when CANCEL is PRESSED.
                // Exit? do it for now... prob need to give the user a warning.
                return;
            }

            String selectedOrganisationIdString = organisationMap.get(list.getSelectedValue());
            
            // Grab all people from the selected organisation
            //PersonList personList = EventorInterface.downloadOrganisationMembers(selectedOrganisationId);
            
            // Now go through each person and grab their results
            // TODO get desired date range from user
            String fromDate = "2017-01-01";
            String toDate = "2017-12-31";
            
            // TODO create the yearArray using this year
            String[] yearArray = {"2017","2016","2015"};
            String yearToGrab = InformationDialog.selectionBox(yearArray, 0, "Select year below...", "Select Year");
            
            fromDate = yearToGrab + "-01-01";
            toDate = yearToGrab + "-12-31";
            
            // Get all of the events organised by selected organisation
            EventorApi.EventList eventList = EventorInterface.getEventList(fromDate, toDate, selectedOrganisationIdString);
            int numberOfEvents = eventList.getEvent().size();
            
            //
            final ProgressBar progressBar = new ProgressBar();

            JFrame frame = new JFrame("NOL Score Calculator Progress");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(progressBar);
            frame.pack();
            frame.setVisible(true);
            
            progressBar.updateBar(0, "Downloading Results for...\n");
            //
            
            // Get each event and grab the data we want    
            ArrayList<ParticipationData> allParticipationData = new ArrayList<>();
            int ii = 0;
            for (EventorApi.Event event : eventList.getEvent()){
                ii += 1;
                String eventName = event.getName().getContent();
                String eventId = event.getEventId().getContent();
                
                progressBar.updateBar((int)Math.round(100.0*(double)(ii+1)/(double)numberOfEvents), event.getName().getContent() + "\n");
                EventorApi.ResultList resultList = EventorInterface.downloadEventorResultListForEventRaceId(event.getEventId().getContent());
                int numberOfParticipants = getNumberOfParticipants(resultList);
                
                String dateString = event.getStartDate().getDate().getContent();
                
                ParticipationData participationData = new ParticipationData(eventId, dateString, eventName, numberOfParticipants);                
                allParticipationData.add(participationData);
            }
            
            //for (Person person : personList.getPerson()){                
                // Get this persons results                
            //}
            
            progressBar.updateBar(100, "Done..." + "\n");
            //progressBar.updateBar(100, "You can close now this window." + "\n");
            frame.dispose();
            
            File fileToSave = getSaveFileLocationFromUser();
            
            writeCsvFile(fileToSave, allParticipationData);
            
            InformationDialog.infoBox("Done! File saved: " + fileToSave.getAbsolutePath(), "Eventor Statistics Grabber Tool");
            
            
            int j = 1;
            /*
            String davidPoland = "304";

            PersonList pl = EventorInterface.downloadResultsForPerson(davidPoland, fromDate, toDate);
            */
        }
        catch (Exception e) {
            
        }
        int jj = 0;
    }
    
    private static int getNumberOfParticipants(EventorApi.ResultList resultList){
        
        // Calculate the number of participants in an Event
        int numberOfParticipants = 0;
        
        for (EventorApi.ClassResult classResult : resultList.getClassResult()){                        
            try {
                int numberofEntriesInThisClass = Integer.parseInt(classResult.getNumberOfEntries());
                numberOfParticipants += numberofEntriesInThisClass;
            }
            catch(Exception e){
                // number of entries could have been null? 
            }                       
        }
        return numberOfParticipants;
    }
    
    private static File getSaveFileLocationFromUser() {

        // Get Save Directory from User
        //
        // Get file directory from user...
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);

        fc.setMultiSelectionEnabled(false);
        fc.setDialogTitle("Specify save location and file name (default will be your Downloads directory)");

        fc.setFileFilter(new FileNameExtensionFilter("CSV Files", "csv"));

        File folder;
        File fileToSave = new File(ORG_SELECTION_DIALOG_STRING);
        if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            fileToSave = fc.getSelectedFile();
        } 
        else {
            String home = System.getProperty("user.home");
            fileToSave = new File(home + "/Downloads/EventorGrabber.csv"); 
        }
        
        // Check we have a ".csv"
        if (!fileToSave.getAbsolutePath().endsWith(".csv")){
            // If not add .csv to the filename
            fileToSave = new File(fileToSave.getAbsolutePath() + ".csv");
        }
        return fileToSave;
    }
    
    private static void writeCsvFile(File fileName, ArrayList<ParticipationData> participationDataList) {

        // TODO get file save location from user        
        FileWriter fileWriter = null;
        try {

            fileWriter = new FileWriter(fileName);

            //Write the CSV file header
            fileWriter.append(ParticipationData.getHEADER_DATA());

            //Write each data object list to the CSV file
            for (ParticipationData participationData : participationDataList) {
                fileWriter.append(participationData.toString());
            }            

        } 
        catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } 
        finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

        }

    }

}
