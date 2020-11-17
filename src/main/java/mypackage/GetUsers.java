/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import java.io.Serializable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;
import mypackage.DBConnectionManager;

/**
 *
 * @author Bogdan
 */
@Named(value = "userData")
@javax.enterprise.context.SessionScoped
public class GetUsers implements Serializable {

    private static final long serialVersionUID = 1L;

    public List<Person> getPersons() throws ClassNotFoundException, SQLException {
        ResultSet rs = null;
        PreparedStatement pst = null;
        DBConnectionManager conn = new DBConnectionManager();
        Connection con = conn.getConnection();
        String stm = "Select * from persons";
        List<Person> records = new ArrayList<Person>();

        try {
            pst = con.prepareStatement(stm);
            pst.execute();
            rs = pst.getResultSet();

            while (rs.next()) {
                Person author = new Person();
                author.setId(rs.getInt(1));
                author.setName(rs.getString(2));
                records.add(author);
            }
            pst.close();
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
