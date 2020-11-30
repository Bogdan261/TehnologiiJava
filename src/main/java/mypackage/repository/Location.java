/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage.repository;

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
@Table(name="location")
@NamedQueries({@NamedQuery(name = "Location.findAll",query = "select e from Location e order by e.name"),})
public class Location {
    @Id 
    private int id;
    @Column(name="name", nullable=false) 
    private String name;
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Location()
    {
        
    }
    
}
