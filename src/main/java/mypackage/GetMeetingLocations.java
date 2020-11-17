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
@ManagedBean(name = "meetingLocations", eager = true)
@SessionScoped
public class GetMeetingLocations implements Serializable {
   private static final long serialVersionUID = 1L;

   public List<MeetingLocation> getMeetings() throws ClassNotFoundException, SQLException {
      ResultSet rs = null;
      PreparedStatement pst = null;
      DBConnectionManager conn = new DBConnectionManager();
      Connection con = conn.getConnection();
      String stm = "Select * from meetinglocation";
      List<MeetingLocation> records = new ArrayList<MeetingLocation>();
      
      try {   
         pst = con.prepareStatement(stm);
         pst.execute();
         rs = pst.getResultSet();

         while(rs.next()) {
            MeetingLocation meetingLocation = new MeetingLocation();
            meetingLocation.meetingId = rs.getInt(1);
            meetingLocation.locationId = rs.getInt(2);
           
            records.add(meetingLocation);				
         }
         pst.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return records;
   }
}