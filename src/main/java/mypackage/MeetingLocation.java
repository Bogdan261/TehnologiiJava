/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

/**
 *
 * @author Bogdan
 */
public class MeetingLocation {
    public int meetingId;
    public int locationId;

    public int getMeetingId() {
        return meetingId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }
    
}
