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
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Bogdan
 */
@Named(value = "meetingsData")
@SessionScoped
public class GetMeetings implements Serializable {

    private static final long serialVersionUID = 1L;

    public List<Meeting> getMeetings() throws ClassNotFoundException, SQLException {
        ResultSet rs = null;
        PreparedStatement pst = null;
        DBConnectionManager conn = new DBConnectionManager();
        Connection con = conn.getConnection();
        String stm = "Select * from meetings";
        List<Meeting> records = new ArrayList<Meeting>();

        try {
            pst = con.prepareStatement(stm);
            pst.execute();
            rs = pst.getResultSet();

            while (rs.next()) {
                Meeting meeting = new Meeting();
                meeting.Id = rs.getInt(1);
                meeting.topic = rs.getString(2);
                meeting.date = rs.getTime(3);
                meeting.duration = rs.getTime(4);
                records.add(meeting);
            }
            pst.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return records;
    }
}
