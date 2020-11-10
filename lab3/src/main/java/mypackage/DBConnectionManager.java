
package mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {
    private Connection connection;
	
	public DBConnectionManager() throws ClassNotFoundException, SQLException{
		Class.forName("org.postgresql.Driver");
                 String url = "jdbc:postgresql://localhost:5432/postgres";
                 String user1 = "postgres";                  
		 this.connection = DriverManager.getConnection(url, user1, "accept");
	}
	
	public Connection getConnection(){
		return this.connection;
	} 
}
 