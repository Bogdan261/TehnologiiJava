/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import mypackage.repository.Location;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import mypackage.repository.Person;

/**
 *
 * @author Bogdan
 */
@Named(value = "setLocations")
@Stateless
@Transactional
public class SetLocations {
    @PersistenceContext(unitName="ExamplePU")
    EntityManager em;
    private int id;
    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void compileData() throws ClassNotFoundException, SQLException {
        Location location = new Location();

        List<Location> locations = em.createNamedQuery("Location.findAll").getResultList();
        int maxId = 0;
        for (int i = 0; i < locations.size(); i++) {
            if (locations.get(i).getId() > maxId) {
                maxId = locations.get(i).getId();
            }
        }

        location.setName(name);
        location.setId(maxId + 1);
        em.persist(location);

    }

}
