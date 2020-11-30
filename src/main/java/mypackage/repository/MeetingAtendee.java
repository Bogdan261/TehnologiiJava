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
@Table(name="meetingatendee")
@NamedQueries({@NamedQuery(name = "MeetingAtendee.findAll",query = "select e from MeetingAtendee e"),})
public class MeetingAtendee {
   
    @Column(name="meeting_id", nullable=false)
    @Id
    public int meetingId;
    @Column(name="person_id", nullable=false) 
    public int personId;

    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getMeetingId() {
        return meetingId;
    }

    public int getPersonId() {
        return personId;
    }
    
}
