/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import mypackage.repository.MeetingAtendee;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import mypackage.repository.MeetingLocation;

/**
 *
 * @author Bogdan
 */
@Named(value = "meetingAtendees")
@Stateless
@Transactional
public class GetMeetingAtendees implements Serializable {

    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = "ExamplePU")
    EntityManager em;

    public List<MeetingAtendee> getMeetings() throws ClassNotFoundException, SQLException {
        List<MeetingAtendee> records = em.createNamedQuery("MeetingAtendee.findAll").getResultList();
        return records;
    }
}
