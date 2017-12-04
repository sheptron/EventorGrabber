/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventorgrabber;

import IofXml30.java.Event;
import IofXml30.java.EventList;
import IofXml30.java.Organisation;
import EventorApi.OrganisationList;
//import IofXml30.java.OrganisationList;
import IofXml30.java.PersonList;
import IofXml30.java.ResultList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.xml.bind.DataBindingException;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author shep
 * 
 * TODO - could use results/organisation to grab selected (ie NOL) results only
 * 
 * Results from:
 * https://eventor.orientering.se/api/results/event/iofxml
 * Using (any) API key
 */
public class EventorInterface {
    
    private static final String EVENTOR_BASE = "https://eventor.orienteering.asn.au/api/";
    public static boolean DEV = false;
    public static String oactStringId = "4";
    
    public static EventList getEventList(String fromDate, String toDate) {
    
        String classificationIds = "1,2"; // 1=Championship, 2=National

            String eventorQuery = "events?fromDate=" + fromDate + "&toDate=" + toDate + "&classificationIds=" + classificationIds;
            String iofXmlType = "EventList";

            String xmlString = EventorInterface.getEventorData(eventorQuery, "From Date " + fromDate + " To Date " + toDate);

            // Hack here - for some reason Eventor doesn't put in the iofVersion number so parsing the XML fails
            xmlString = xmlString.replace("<EventList>", "<EventList xmlns=\"http://www.orienteering.org/datastandard/3.0\" iofVersion=\"3.0\">");

            EventList eventList = JAXB.unmarshal(new StringReader(xmlString), EventList.class);
            
            return eventList;
    }
    
    public static EventorApi.EventList getEventList(String fromDate, String toDate, String organisationIdString){
        /*
        
        GET https://eventor.orientering.se/api/events
        Returnerar en lista med tävlingar som matchar sökparametrarna.
        
        fromDate 		0000-01-01              Startdatum (åååå-mm-dd).
        toDate                  9999-12-31              Slutdatum (åååå-mm-dd).
        fromModifyDate 		0000-01-01 00:00:00 	Inkluderar endast tävlingar som ändrats efter denna tidpunkt (åååå-mm-dd hh:mm:ss).
        toModifyDate 		9999-12-31 23:59:59 	Inkluderar endast tävlingar som ändrats före denna tidpunkt (åååå-mm-dd hh:mm:ss).
        eventIds                                        Kommaseparerad lista med tävlings-id:n. Utelämna för att inkludera alla tävlingar.
        organisationIds                                 Kommaseparerad lista med organisations-id:n för arrangörsklubbarna. Om ett distrikts organisations-id anges kommer alla tävlingar som arrangeras av en klubb i distriktet att inkluderas. Utelämna för att inkludera alla tävlingar.
        classificationIds                               Kommaseparerad lista med tävlingstyps-id:n, där 1=mästerskapstävling, 2=nationell tävling, 3=distriktstävling, 4=närtävling, 5=klubbtävling, 6=internationell tävling. Utelämna för att inkludera alla tävlingar.
        includeEntryBreaks 		false           Sätt till true för att inkludera tävlingens anmälningsstopp.
        includeAttributes 		false           Sätt till true för att inkludera tävlingens tävlingsattribut.
        */
        
        String eventorQuery = "events?fromDate=" + fromDate + "&toDate=" + toDate + "&organisationIds=" + organisationIdString;        
        String iofXmlType = "EventList";
        String xmlString = EventorInterface.getEventorData(eventorQuery, "From Date " + fromDate + " To Date " + toDate);
        
        EventorApi.EventList eventList = JAXB.unmarshal(new StringReader(xmlString), EventorApi.EventList.class);
        
        return eventList;
    }

    public static String getEventorData(String eventorQuery, String description) {

        String xmlString = "";
        String API_KEY = EventorApiKey.getApiKey();
        URL baseUrl;

        try {
            baseUrl = new URL(EVENTOR_BASE + eventorQuery);
        }
        catch (MalformedURLException e){
            JFrame frame = new JFrame("Warning");
            JOptionPane.showMessageDialog(frame, e.getMessage());
            return xmlString;
        }

        try {

            URLConnection con = baseUrl.openConnection();

            con.setRequestProperty("Accept", "application/xml");
            con.setRequestProperty("ApiKey", API_KEY);

            //String xmlString;
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            //xmlString = "";
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                xmlString += inputLine;
            }
            //System.out.println(inputLine);
        } catch (IOException io) {
            System.out.println("Catching IOException");            
            System.out.println(io.getMessage());
            String warning = "Trying to get data for \"" + description + "\" got this error: " + io.getMessage();
            JOptionPane.showMessageDialog(null, warning);
        }

        return xmlString;
    }
            
    public static ResultList downloadResultList(EventList eventList, int eventIndex) throws Exception {
        
        String eventId = eventList.getEvent().get(eventIndex).getEventorId().getValue();
                
        String eventorQuery = "results/event/iofxml?eventId=" + eventId;
        String description = eventList.getEvent().get(eventIndex).getName();
        String xmlString = getEventorData(eventorQuery, description);
          
        if (xmlString.equals("")){
            // Somethings gone wrong in the download
            // We've alread shown a message - just make sure whoever asked for this data knows we've had an exception...
            throw new IOException();
        }
        
        try{        
            // Testing ONLY
            if (DEV) stringToFile(xmlString, description); // Dump downloaded XML to a file
            
            ResultList thisResultList = JAXB.unmarshal(new StringReader(xmlString), ResultList.class);        
            return thisResultList;
        }
        catch (DataBindingException e){
            return new ResultList();
        }
    }
    
    public static ResultList downloadResultListForEventRaceId(String eventId, String eventRaceId) throws Exception {
        
        // Returns IOF XML Results
        String eventorQuery = "results/event/iofxml?eventId=" + eventId + "&eventRaceId=" + eventRaceId;
        String description = eventId + " : " + eventRaceId;
        String xmlString = getEventorData(eventorQuery, description);
          
        if (xmlString.equals("")){
            // Somethings gone wrong in the download
            // We've alread shown a message - just make sure whoever asked for this data knows we've had an exception...
            throw new IOException();
        }
        
        try{        
            // Testing ONLY
            if (DEV) stringToFile(xmlString, description); // Dump downloaded XML to a file
            
            ResultList thisResultList = JAXB.unmarshal(new StringReader(xmlString), ResultList.class);        
            return thisResultList;
        }
        catch (DataBindingException e){
            return new ResultList();
        }
    }
    
    public static EventorApi.ResultList downloadEventorResultListForEventRaceId(String eventId) throws IOException{
        
        /*        
        GET https://eventor.orientering.se/api/results/event
        
        Returnerar resultat för en tävling.
        eventId 			Tävlings-id enligt /events.
        includeSplitTimes 			Sätt till true för att inkludera sträcktider.
        top 			Returnerar endast detta antal deltagare från toppen av resultatlistan. Utelämna för att inkludera alla deltagare.
        */
        // Returns Eventor XML Results
        String eventorQuery = "results/event?eventId=" + eventId;
        String description = eventId;
        String xmlString = getEventorData(eventorQuery, description);
          
        if (xmlString.equals("")){
            // Somethings gone wrong in the download
            // We've alread shown a message - just make sure whoever asked for this data knows we've had an exception...
            throw new IOException();
        }
        
        try{        
            // Testing ONLY
            if (DEV) stringToFile(xmlString, description); // Dump downloaded XML to a file
            
            EventorApi.ResultList thisResultList = JAXB.unmarshal(new StringReader(xmlString), EventorApi.ResultList.class);        
            return thisResultList;
        }
        catch (DataBindingException e){
            return new EventorApi.ResultList();
        }
    }
    
    public static Event downloadEvent(String eventId)  throws Exception{
        // https://eventor.orientering.se/api/event/{eventId}
        String eventorQuery = "event/" + eventId;
        String description = "";
        
        String xmlString = getEventorData(eventorQuery, description);
          
        if (xmlString.equals("")){
            // Somethings gone wrong in the download
            // We've alread shown a message - just make sure whoever asked for this data knows we've had an exception...
            throw new IOException();
        }
        
        try{        
            // Testing ONLY
            if (DEV) stringToFile(xmlString, description); // Dump downloaded XML to a file
            
            Event event = JAXB.unmarshal(new StringReader(xmlString), Event.class);        
            return event;
        }
        catch (DataBindingException e){
            return new Event();
        }
        
        
    }    
    
     public static ArrayList<String> downloadListOfEventRaceIds(String eventId)  throws Exception{
        // https://eventor.orientering.se/api/event/{eventId}
        String eventorQuery = "event/" + eventId;
        String description = "";
        
        String patternString = "<EventRaceId>(\\d+)</EventRaceId>";               
        
        String xmlString = getEventorData(eventorQuery, description);        
        
        if (xmlString.equals("")){
            // Somethings gone wrong in the download
            // We've alread shown a message - just make sure whoever asked for this data knows we've had an exception...
            throw new IOException();
        }
        
        try{        
            // Testing ONLY
            if (DEV) stringToFile(xmlString, description); // Dump downloaded XML to a file
            
            ArrayList<String> eventRaceIds = new ArrayList<>();
            
            Pattern pattern = Pattern.compile(patternString);
            Matcher matcher = pattern.matcher(xmlString);
            
            while(matcher.find()) {                                
                eventRaceIds.add(matcher.group(1));        
            }
            return eventRaceIds;

        }
        catch (DataBindingException e){
            return new ArrayList<>();
        }
        
        
    } 
     
     /*
     GET https://eventor.orientering.se/api/organisations
Returnerar en lista med samtliga organisationer (förbund, distriktsförbund och klubbar).

Query parameters
Name	Req	Default	Description
includeProperties		false	Sätt till true för att inkludera utökad information om organisationerna.
Returned element

OrganisationList
     */
     public static OrganisationList downloadOrganisations()  throws Exception{
        // https://eventor.orientering.se/api/organisations
        String eventorQuery = "organisations";
        String description = "";
        
        //String xmlString = getEventorData(eventorQuery, description);
          
        String xmlString = new String(Files.readAllBytes(Paths.get("/home/shep/Desktop/organisations")));
        if (xmlString.equals("")){
            // Somethings gone wrong in the download
            // We've alread shown a message - just make sure whoever asked for this data knows we've had an exception...
            throw new IOException();
        }
        
        try{        
            // Testing ONLY
            if (DEV) stringToFile(xmlString, description); // Dump downloaded XML to a file
            
            //JAXBContext context = JAXBContext.newInstance(EventorApi.OrganisationList.class);
            //Unmarshaller unmarshaller = context.createUnmarshaller();
            //unmarshaller.setEventHandler(new javax.xml.bind.helpers.DefaultValidationEventHandler());
            
            //StringReader reader = new StringReader(xmlString);
            //OrganisationList orgList = (OrganisationList) unmarshaller.unmarshal(reader);

            
            // TODO this unmarshalling is failing
            OrganisationList organisationList = JAXB.unmarshal(new StringReader(xmlString), OrganisationList.class);        
            return organisationList;
        }
        catch (DataBindingException e){
            return new OrganisationList();
        }  
    }    
     
     public static Organisation downloadOrganisation()  throws Exception{
        // https://eventor.orientering.se/api/organisations
        String description = "";
        
        String eventorQuery = "organisation/" + "11";// + oactStringId;
        
        
        String xmlString = getEventorData(eventorQuery, description);
          
        if (xmlString.equals("")){
            // Somethings gone wrong in the download
            // We've alread shown a message - just make sure whoever asked for this data knows we've had an exception...
            throw new IOException();
        }
        
        try{        
            // Testing ONLY
            if (DEV) stringToFile(xmlString, description); // Dump downloaded XML to a file
            
            // TODO this unmarshalling is failing
            Organisation organisation = JAXB.unmarshal(new StringReader(xmlString), Organisation.class);        
            return organisation;
        }
        catch (DataBindingException e){
            return new Organisation();
        }  
    }   
     
     /*
     GET https://eventor.orientering.se/api/persons/organisations/{organisationId}
Returnerar alla personer som är medlemmar i en organisation.

Path parameters
Name	Req	Default	Description
organisationId	yes		Organisationens id enligt /organisations. Denna parameter måste sättas till den egna organisationens id.
Query parameters
Name	Req	Default	Description
includeContactDetails		false	Sätt till true för att inkludera medlemmarnas adresser, telefonnummer och e-postadresser.
Returned element

PersonList
     */
     
     public static EventorApi.PersonList downloadOrganisationMembers(String organisationIdString)  throws Exception{
        // https://eventor.orientering.se/api/organisations
        String description = "";
        
        String eventorQuery = "persons/organisations/" + organisationIdString + "?includeContactDetails=True"; // 12 is Bushflyers
        
        
        String xmlString = getEventorData(eventorQuery, description);
          
        if (xmlString.equals("")){
            // Somethings gone wrong in the download
            // We've alread shown a message - just make sure whoever asked for this data knows we've had an exception...
            throw new IOException();
        }
        
        try{        
            // Testing ONLY
            if (DEV) stringToFile(xmlString, description); // Dump downloaded XML to a file
            
            // TODO this unmarshalling is failing
            EventorApi.PersonList personList = JAXB.unmarshal(new StringReader(xmlString), EventorApi.PersonList.class);        
            return personList;
        }
        catch (DataBindingException e){
            return new EventorApi.PersonList();
        }  
    }   
     
     /*
     
     GET https://eventor.orientering.se/api/results/person
Returnerar resultat för en person på ett antal tävlingar.

Query parameters
Name	Req	Default	Description
personId			Person-id enligt /persons/organisations/{organisationId}.
eventIds			Kommaseparerad lista med tävlings-id:n enligt /events. Utelämna för att inkludera alla tävlingar.
fromDate		0000-01-01	Inkluderar tävlingar som arrangeras under detta eller senare datum (åååå-mm-dd).
toDate		9999-12-31	Inkluderar tävlingar som arrangeras under detta eller tidigare datum (åååå-mm-dd).
includeSplitTimes			Sätt till true för att inkludera sträcktider.
top			Returnerar, förutom den angivna personen, endast detta antal deltagare från toppen av resultatlistan. Utelämna för att inkludera endast den angivna personen.
Returned element

ResultListList
     
     */
     
     public static PersonList downloadResultsForPerson(String personIdString, String fromDate, String toDate)  throws Exception{
        // https://eventor.orientering.se/api/organisations
        String description = "";
        
        String eventorQuery = "results/person?personId=" + personIdString + "&fromDate=" + fromDate + "&toDate=" + toDate; 
        
        
        String xmlString = getEventorData(eventorQuery, description);
          
        if (xmlString.equals("")){
            // Somethings gone wrong in the download
            // We've alread shown a message - just make sure whoever asked for this data knows we've had an exception...
            throw new IOException();
        }
        
        try{        
            // Testing ONLY
            if (DEV) stringToFile(xmlString, description); // Dump downloaded XML to a file
            
            // TODO this unmarshalling is failing
            PersonList personList = JAXB.unmarshal(new StringReader(xmlString), PersonList.class);        
            return personList;
        }
        catch (DataBindingException e){
            return new PersonList();
        }  
    }   
    
    public static void stringToFile(String xmlSource, String description) throws IOException {
        
        String cleanedDescription = description.replace("/", "-");
        java.io.FileWriter fw = new java.io.FileWriter("/home/shep/Desktop/" + cleanedDescription + ".xml");
        //fw.write(xmlSource);       
        //fw.close();
        
        BufferedWriter out = new BufferedWriter(fw);
        out.write(xmlSource);
        out.close();
        fw.close();
    }
}
