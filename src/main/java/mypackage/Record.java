/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import java.util.List;

/**
 *
 * @author Bogdan
 */
public class Record {
    private String topic;
    private String location;
    private String participant;

    public String getTopic() {
        return topic;
    }

    public String getLocation() {
        return location;
    }

    public String getParticipant() {
        return participant;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setParticipant(String participant) {
        this.participant = participant;
    }
    
}
