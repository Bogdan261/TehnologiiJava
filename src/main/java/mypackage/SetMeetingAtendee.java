/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import mypackage.repository.Meeting;
import mypackage.repository.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import mypackage.repository.Location;
import mypackage.repository.MeetingAtendee;
import mypackage.repository.MeetingLocation;

/**
 *
 * @author Bogdan
 */
@Named(value = "setMeetingAtendee")
@Stateless
@Transactional
public class SetMeetingAtendee {

    @PersistenceContext(unitName = "ExamplePU")
    EntityManager em;
    private int meetingId;
    private int participantId;

    public int getMeetingId() {
        return meetingId;
    }

    public int getParticipantId() {
        return participantId;
    }

    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    public void compileData() throws ClassNotFoundException, SQLException {
        List<Person> persons = em.createNamedQuery("Person.findAll").getResultList();
        List<Meeting> meetings = em.createNamedQuery("Meeting.findAll").getResultList();
        boolean foundMeeting = false, foundLocation = false;
        for (int i = 0; i < meetings.size(); i++) {
            if (meetings.get(i).getId() == meetingId) {
                foundMeeting = true;
            }
        }
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getId() == participantId) {
                foundLocation = true;
            }
        }
        if (foundLocation && foundMeeting) {
            MeetingAtendee ml = new MeetingAtendee();
            ml.personId = participantId;
            ml.meetingId = meetingId;
            em.persist(ml);
        }

    }
}
