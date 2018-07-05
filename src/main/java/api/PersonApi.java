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
    public boolean addPerson(Person person)
    {
        System.out.println(person);
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
    public Person getPersonByPesel(@PathParam("pesel") Long pesel)
    {
        return personService.findByPesel(pesel);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean updatePerson(Person person)
    {
        try
        {
            personService.findByPesel(person.getPesel());
            personService.update(person);
            return true;
        }
        catch (NoResultException e)
        {
            return false;
        }
    }

    @DELETE
    @Produces("application/json")
    @Path("/delete/{pesel}")
    public List<Person> deletePerson(@PathParam("pesel") Long pesel)
    {
        personService.delete(pesel);
        return personService.findAll();
    }
}
