/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Bogdan
 */
@ManagedBean(name = "setMeetingAtendee", eager = true)
@RequestScoped
public class SetMeetingAtendee {
    private int meetingId;
    public int participantId;

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
    
   
    
    public void compileData() throws ClassNotFoundException, SQLException
    {
      PreparedStatement pst = null;
      DBConnectionManager conn = new DBConnectionManager();
      Connection con = conn.getConnection();
      if(con!=null)
      {
       try{
      GetUsers usrs = new GetUsers();
      List<Person> persons = usrs.getPersons();
      GetMeetings mtgs = new GetMeetings();
      List<Meeting> meetings = mtgs.getMeetings();
      boolean foundMeeting = false, foundPerson = false;
      for(int i = 0; i<meetings.size();i++)
          if(meetings.get(i).Id == meetingId)
              foundMeeting = true;
      for(int i = 0; i<persons.size();i++)
          if(persons.get(i).id == participantId)
              foundPerson = true;
      if(foundPerson && foundMeeting)
      {
         PreparedStatement st = con.prepareStatement("INSERT INTO meetingatendee (meeting_id,person_id) VALUES (?,?)");
         st.setInt(1, meetingId);
         st.setInt(2, participantId);
         st.executeUpdate();
         st.close();
      }
       }
       catch (SQLException e) {
         e.printStackTrace();
      }
       
      }
      
       
    }
}
    