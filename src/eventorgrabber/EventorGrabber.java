/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventorgrabber;

import IofXml30.java.Id;
import IofXml30.java.Organisation;
import EventorApi.OrganisationList;
import EventorApi.Person;
import EventorApi.PersonList;
import EventorApi.EventList;
//import IofXml30.java.OrganisationList;
//import IofXml30.java.PersonList;
import java.util.HashMap;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;



/**
 *
 * @author shep
 */
public class EventorGrabber {
    
    public static final String ORG_SELECTION_DIALOG_STRING = "Select all the Organisation from the list below...";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
        
            // First get a list of organisations
            OrganisationList organisationList = EventorInterface.downloadOrganisations();
            
            HashMap<String,String> organisationMap = new HashMap();
            for (EventorApi.Organisation organisation : organisationList.getOrganisation()) {
                // State Associations are OrganisationTypeId = 2, clubs OrganisationTypeId = 3
                if (organisation.getOrganisationTypeId().getContent().equals("2"))
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
            String fromDate = "2017-10-01";
            String toDate = "2017-10-31";
            
            // Get all of the events organised by selected organisation
            EventorApi.EventList eventList = EventorInterface.getEventList(fromDate, toDate, selectedOrganisationIdString);
            
                        
            //for (Person person : personList.getPerson()){                
                // Get this persons results                
            //}
            
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
    
}
