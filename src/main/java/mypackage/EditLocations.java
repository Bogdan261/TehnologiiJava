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
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Bogdan
 */
@Named(value = "editLocations")
@RequestScoped
public class EditLocations {

    private int id;
    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return id;
    }

    public void compileData() throws ClassNotFoundException, SQLException {
        PreparedStatement pst = null;
        DBConnectionManager conn = new DBConnectionManager();
        Connection con = conn.getConnection();
        if (con != null) {
            try {
                PreparedStatement st = con.prepareStatement("update location set name ='" + name + "' where id =" + id);
                st.executeUpdate();
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }            

        }

    }

}
