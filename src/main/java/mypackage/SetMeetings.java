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
import mypackage.repository.Meeting;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import mypackage.repository.Person;

@Named(value = "setMeetings")
@Stateless
@Transactional
public class SetMeetings {

    private int id;
    private String topic;
    private Date date;
    private Date duration;
    @PersistenceContext(unitName = "ExamplePU")
    EntityManager em;

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

        List<Meeting> meetings = em.createNamedQuery("Meeting.findAll").getResultList();
        int maxId = 0;
        for (int i = 0; i < meetings.size(); i++) {
            if (meetings.get(i).getId() > maxId) {
                maxId = meetings.get(i).getId();
            }
        }
        Meeting meeting = new Meeting();
        meeting.setId(maxId + 1);
        meeting.setTopic(topic);
        meeting.setDate(new Time(date.getTime()));
        meeting.setDuration(new Time(duration.getTime()));
        em.persist(meeting);

    }
}
