/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import mypackage.repository.Location;

/**
 *
 * @author Bogdan
 */
@Named(value = "editLocations")
@Stateless
@Transactional
public class EditLocations {

    private int id;
    private String name;
    @PersistenceContext(unitName = "ExamplePU")
    EntityManager em;

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
       
        Location location = em.find(Location.class, id);
        location.setName(name);       
    }

}
