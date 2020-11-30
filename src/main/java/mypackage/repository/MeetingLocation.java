/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Bogdan
 */
@Entity
@Table(name="meetinglocation")
@NamedQueries({@NamedQuery(name = "MeetingLocation.findAll",query = "select e from MeetingLocation e"),})
public class MeetingLocation {
    
    @Column(name="meeting_id", nullable=false)
    @Id
    public int meetingId;
    @Column(name="location_id", nullable=false)
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
