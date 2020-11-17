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
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Bogdan
 */
@Named(value = "setLocations")
@RequestScoped
public class SetLocations {
    private int id;
    private String name;
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public void setName(String name)
    {
        this.name= name;
    }
    public String getName()
    {
        return this.name;
    }
    
    public void compileData() throws ClassNotFoundException, SQLException
    {
      PreparedStatement pst = null;
      DBConnectionManager conn = new DBConnectionManager();
      Connection con = conn.getConnection();
      if(con!=null)
      {
       try{
      GetLocations lctn = new GetLocations();
      List<Location> locations = lctn.getLocations();
      int maxId = 0;
      for(int i = 0; i<locations.size();i++)
          if(locations.get(i).getId() > maxId)
              maxId = locations.get(i).getId();
      PreparedStatement st = con.prepareStatement("INSERT INTO location (id,name) VALUES (?,?)");
      st.setInt(1, maxId + 1);
      st.setString(2, name);
      st.executeUpdate();
      st.close();
       }
       catch (SQLException e) {
         e.printStackTrace();
      }
       
      }
       
    }
    
    
}
