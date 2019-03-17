
package DAO;

import Entity.Phone;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PhoneDAO {
    
    @PersistenceContext(name = "PU")
    EntityManager em;
    
    public void addPhone(Phone p){
        em.persist(p);
    }
    
    public void deletePhone(int id){
        em.remove(em.find(Phone.class, id));
    }
    
    public List<Phone> listAllPhones(){
        return em.createQuery("SELECT po FROM Phone po").getResultList();
    }   
    
}
