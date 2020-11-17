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
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.inject.Named;

@Named(value = "setMeetings")
@javax.enterprise.context.RequestScoped
public class SetMeetings {

    private int id;
    private String topic;
    private Date date;
    private Date duration;

    public Date getDate() {
        return date;
    }

    public Date getDuration() {
        return duration;
    }

    public void setDate(Date date) {
        this.date = new Date(date.getTime());
    }

    public void setDuration(Date duration) {
        this.duration = new Date(duration.getTime());
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTopic() {
        return this.topic;
    }

    public void compileData() throws ClassNotFoundException, SQLException {

        long now = System.currentTimeMillis();
        PreparedStatement pst = null;
        DBConnectionManager conn = new DBConnectionManager();
        Connection con = conn.getConnection();
        if (con != null) {
            try {
                GetMeetings mtgs = new GetMeetings();
                List<Meeting> meetings = mtgs.getMeetings();
                int maxId = 0;
                for (int i = 0; i < meetings.size(); i++) {
                    if (meetings.get(i).Id > maxId) {
                        maxId = meetings.get(i).Id;
                    }
                }
                PreparedStatement st = con.prepareStatement("INSERT INTO meetings (id,topic,start,duration) VALUES (?,?,?,?)");
                st.setInt(1, maxId + 1);
                st.setString(2, topic);
                st.setTime(3, new Time(date.getTime()));
                st.setTime(4, new Time(duration.getTime()));
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
