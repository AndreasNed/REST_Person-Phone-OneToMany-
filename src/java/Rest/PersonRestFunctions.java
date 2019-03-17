package Rest;

import DAO.PersonDAO;
import Entity.Person;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("person")
public class PersonRestFunctions {

    @Inject
    PersonDAO dao;

    @Consumes({MediaType.APPLICATION_JSON})
    @PUT
    public void addPerson(Person p) {
        dao.addPerson(p);
    }

    @Produces({MediaType.APPLICATION_JSON})
    @GET
    public List<Person> findAllPersons() {
        return dao.listAllPersons();
    }
    
    @DELETE
    @Path("/delete/{id}")
    public void removePerson(@PathParam("id") int id) {
        dao.deletePerson(id);
    }

}
