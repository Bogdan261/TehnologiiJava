/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import mypackage.repository.Meeting;
import mypackage.repository.Location;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import mypackage.repository.MeetingLocation;

/**
 *
 * @author Bogdan
 */
@Named(value = "setMeetingLocation")
@Stateless
@Transactional
public class SetMeetingLocation {

    @PersistenceContext(unitName = "ExamplePU")
    EntityManager em;
    
    private int meetingId;
    private int locationId;
    
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
    
    public void compileData() throws ClassNotFoundException, SQLException {
        /*
        PreparedStatement pst = null;
        DBConnectionManager conn = new DBConnectionManager();
        Connection con = conn.getConnection();
        if (con != null) {
            try {
                GetLocations lcns = new GetLocations();
                List<Location> locations = lcns.getLocations();
                GetMeetings mtgs = new GetMeetings();
                List<Meeting> meetings = mtgs.getMeetings();
                boolean foundMeeting = false, foundLocation = false;
                for (int i = 0; i < meetings.size(); i++) {
                    if (meetings.get(i).getId() == meetingId) {
                        foundMeeting = true;
                    }
                }
                for (int i = 0; i < locations.size(); i++) {
                    if (locations.get(i).getId() == locationId) {
                        foundLocation = true;
                    }
                }
                if (foundLocation && foundMeeting) {
                    PreparedStatement st = con.prepareStatement("INSERT INTO meetinglocation (meeting_id,location_id) VALUES (?,?)");
                    st.setInt(1, meetingId);
                    st.setInt(2, locationId);
                    st.executeUpdate();
                    st.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
         */ List<Location> locations = em.createNamedQuery("Location.findAll").getResultList();
        List<Meeting> meetings = em.createNamedQuery("Meeting.findAll").getResultList();
        boolean foundMeeting = false, foundLocation = false;
        for (int i = 0; i < meetings.size(); i++) {
            if (meetings.get(i).getId() == meetingId) {
                foundMeeting = true;
            }
        }
        for (int i = 0; i < locations.size(); i++) {
            if (locations.get(i).getId() == locationId) {
                foundLocation = true;
            }
        }
        if (foundLocation && foundMeeting) {
            MeetingLocation ml = new MeetingLocation();
            ml.locationId = locationId;
            ml.meetingId = meetingId;
            em.persist(ml);
        }
        
    }
}
