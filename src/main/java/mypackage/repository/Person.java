
package mypackage.repository;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="persons")
@NamedQueries({@NamedQuery(name = "Person.findAll",query = "select e from Person e order by e.name"),})
public class Person implements Serializable {
   @Id 
   int id;
   
   @Column(name="name", nullable=false) 
   private String name;
   
   public String getName() {
      return name;
   }
   
   public void setName(String name) {
      this.name = name;
   }
   
   public int getId() {
      return id;
   }
   
   public void setId(int id) {
      this.id = id;
   }
   public Person()
   {
   }
   
}