/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventorgrabber;

import IofXml30.java.OrganisationList;
import IofXml30.java.PersonList;



/**
 *
 * @author shep
 */
public class EventorGrabber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
        
            //OrganisationList organisationList = EventorInterface.downloadOrganisations();
            //PersonList personList = EventorInterface.downloadOrganisationMembers();
            
            String davidPoland = "304";
            String fromDate = "2017-10-01";
            String toDate = "2017-10-31";
            PersonList pl = EventorInterface.downloadResultsForPerson(davidPoland, fromDate, toDate);
        }
        catch (Exception e) {
            
        }
        int jj = 0;
    }
    
}
