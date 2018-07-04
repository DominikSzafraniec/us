package api;

import model.Person;
import service.PersonService;

import javax.persistence.NoResultException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/persons")
public class PersonApi {
    private PersonService personService=new PersonService();
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean addUser(Person person)
    {
        try
        {
            personService.findByPesel(person.getPesel());
            return false;
        }
        catch (NoResultException e)
        {
            personService.persist(person);
            return true;
        }
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getListOfPerson()
    {
        return personService.findAll();
    }

    @GET
    @Path("/{pesel}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonByPesel(@PathParam("pesel") String pesel)
    {
        return personService.findByPesel(Long.valueOf(pesel));
    }
}
