/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import mypackage.repository.Person;
import java.io.Serializable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import mypackage.DBConnectionManager;
import mypackage.repository.Location;

/**
 *
 * @author Bogdan
 */
@Named(value = "userData")
@Stateless
@Transactional
public class GetUsers implements Serializable {

    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName = "ExamplePU")
    EntityManager em;

    public List<Person> getPersons() throws ClassNotFoundException, SQLException {
        List<Person> records = em.createNamedQuery("Person.findAll").getResultList();

        return records;
    }
}
