/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage.repository;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Bogdan
 */
@Entity
@Table(name = "meetings")
@NamedQueries({
    @NamedQuery(name = "Meeting.findAll", query = "select e from Meeting e order by e.topic"),})
public class Meeting {

    @Id
    int Id;
    @Column(name = "topic", nullable = false)
    String topic;
    @Column(name = "start", nullable = false)
    Time date;
    @Column(name = "duration", nullable = false)
    Time duration;

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setDate(Time date) {
        this.date = date;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public int getId() {
        return Id;
    }

    public String getTopic() {
        return topic;
    }

    public Time getDate() {
        return date;
    }

    public Time getDuration() {
        return duration;
    }

}
