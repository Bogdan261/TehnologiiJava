/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

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
import mypackage.repository.Person;

/**
 *
 * @author Bogdan
 */
@Named(value = "applicationData")
@Stateless
@Transactional
public class ApplicationData {
    @PersistenceContext(unitName = "ExamplePU")
    EntityManager em;
    public List<Record> getRecords() throws ClassNotFoundException, SQLException {
        List<Record> records = em.createQuery("select new Record(m.topic,l.name,p.name) from Meeting m left join MeetingAtendee ma "
        + " left join Person p  left join MeetingLocation ml left join Location l where m.Id = ma.meetingId and ma.personId = p.id and m.Id = ml.meetingId and l.id = ml.locationId").getResultList();
        return records;
    }
}


