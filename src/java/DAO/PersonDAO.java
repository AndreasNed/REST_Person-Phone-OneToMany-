
package DAO;

import Entity.Person;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PersonDAO {
    
    @PersistenceContext(name = "PU")
    EntityManager em;
    
    public void addPerson(Person p){    
        em.persist(p);
    }
   
    
    public void deletePerson(int id){
        em.remove(em.find(Person.class, id));
    }
    
    public List<Person> listAllPersons(){
        return em.createQuery("SELECT p FROM Person p").getResultList();
    }   
    
}
