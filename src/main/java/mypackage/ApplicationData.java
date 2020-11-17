/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

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
@ManagedBean(name = "applicationData", eager = true)
@SessionScoped
public class ApplicationData {

    public List<Record> getRecords() throws ClassNotFoundException, SQLException {
        ResultSet rs = null;
        PreparedStatement pst = null;
        DBConnectionManager conn = new DBConnectionManager();
        Connection con = conn.getConnection();
        String stm = "select m.topic, p.name, l.name from meetings m join meetingatendee ma on m.id=ma.meeting_id join persons p on p.id = ma.person_id join "
                + "meetinglocation ml on ml.meeting_id = m.id join location l on l.id= ml.location_id";
        List<Record> records = new ArrayList<Record>();
        try {
            pst = con.prepareStatement(stm);
            pst.execute();
            rs = pst.getResultSet();

            while (rs.next()) {
                Record result = new Record();
                result.setTopic(rs.getString(1));
                result.setParticipant(rs.getString(2));
                result.setLocation(rs.getString(3));
                records.add(result);
            }
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return records;
    }
}


