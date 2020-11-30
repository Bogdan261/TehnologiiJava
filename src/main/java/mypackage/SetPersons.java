package mypackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import mypackage.repository.Person;

/**
 *
 * @author Bogdan
 */


@Named(value = "setPersons")
@Stateless
@Transactional
public class SetPersons implements Serializable {
    private int id;
    private String name;
    @PersistenceContext(unitName="ExamplePU")
    EntityManager em;
    //@Resource
    //UserTransaction utx;
    public void setId(int id)
    {
        this.id = id;
    }
    
    public void setName(String name)
    {
        this.name= name;
    }
    public String getName()
    {
        return this.name;
    }
   
    public void compileData() 
    {      
      Person person = new Person();
   
      List<Person> persons = em.createNamedQuery("Person.findAll").getResultList();
      int maxId = 0;
      for( int i = 0; i < persons.size(); i++)
          if(persons.get(i).getId() > maxId)
              maxId = persons.get(i).getId();        
          
      person.setName(name);
      person.setId(maxId + 1);
      em.persist(person);    
       
    }
    
    
}
