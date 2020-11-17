/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

/**
 *
 * @author Bogdan
 */
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Named;

@Named(value = "setPersons")
@javax.enterprise.context.RequestScoped
public class SetPersons {

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
                GetUsers usrs = new GetUsers();
                List<Person> persons = usrs.getPersons();
                int maxId = 0;
                for (int i = 0; i < persons.size(); i++) {
                    if (persons.get(i).id > maxId) {
                        maxId = persons.get(i).id;
                    }
                }
                PreparedStatement st = con.prepareStatement("INSERT INTO persons (id,name) VALUES (?,?)");
                st.setInt(1, maxId + 1);
                st.setString(2, name);
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
