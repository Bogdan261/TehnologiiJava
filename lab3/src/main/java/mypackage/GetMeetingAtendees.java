/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Bogdan
 */
@ManagedBean(name = "meetingAtendees", eager = true)
@SessionScoped
public class GetMeetingAtendees implements Serializable {
   private static final long serialVersionUID = 1L;

   public List<MeetingAtendee> getMeetings() throws ClassNotFoundException, SQLException {
      ResultSet rs = null;
      PreparedStatement pst = null;
      DBConnectionManager conn = new DBConnectionManager();
      Connection con = conn.getConnection();
      String stm = "Select * from meetingatendee";
      List<MeetingAtendee> records = new ArrayList<MeetingAtendee>();
      
      try {   
         pst = con.prepareStatement(stm);
         pst.execute();
         rs = pst.getResultSet();

         while(rs.next()) {
            MeetingAtendee meetingAtendee = new MeetingAtendee();
            meetingAtendee.meetingId = rs.getInt(1);
            meetingAtendee.personId = rs.getInt(2);
           
            records.add(meetingAtendee);				
         }
         pst.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return records;
   }
}