/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventorgrabber;

/**
 *
 * @author shep
 */
public class ParticipationData {
    
    public static String HEADER_DATA = "Event Id,Date,Event Name,Competitor Count\n";
    
    public String eventId;
    public String eventName;
    public int competitorCount;
    public String dateString;
    // Date

    public ParticipationData(String eventId, String dateString, String eventName, int competitorCount) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.competitorCount = competitorCount;
        this.dateString = dateString;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getCompetitorCount() {
        return competitorCount;
    }

    public void setCompetitorCount(int competitorCount) {
        this.competitorCount = competitorCount;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }
    
    @Override
    public String toString(){
        // Use this for writing to CSV
        // eventname sometimes has a comma so put quotes around it
        return eventId + "," + dateString + "," + "\"" + eventName + "\"" + "," + Integer.toString(competitorCount) + "\n";
    }

    public static String getHEADER_DATA() {
        return HEADER_DATA;
    }
    
}
