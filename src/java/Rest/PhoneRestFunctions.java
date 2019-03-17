package Rest;

import DAO.PhoneDAO;
import Entity.Phone;
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
@Path("phone")
public class PhoneRestFunctions {

    @Inject
    PhoneDAO dao;

    @Consumes({MediaType.APPLICATION_JSON})
    @PUT
    public void addPhone(Phone p) {
        dao.addPhone(p);
    }

    @Produces({MediaType.APPLICATION_JSON})
    @GET
    public List<Phone> findAllPhones() {
        return dao.listAllPhones();
    }

    @DELETE
    @Path("/delete/{id}")
    public void removePhone(@PathParam("id") int id) {
        dao.deletePhone(id);
    }

}
