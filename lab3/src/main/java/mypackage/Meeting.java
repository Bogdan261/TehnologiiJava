/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

/**
 *
 * @author Bogdan
 */
public class Meeting {
    int Id;
    String topic;
    Time date;
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
