package api;

import model.User;
import service.PersonService;
import service.UserService;

import javax.persistence.NoResultException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
@Path("/users")
public class UserApi {
    private UserService userService=new UserService();
    private PersonService personService=new PersonService();
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean addUser(User user)
    {
        try
        {
            userService.findByLogin(user.getLogin());
            return false;
        }
        catch (NoResultException e)
        {
            try
            {
                user.setPerson(personService.findByPesel(user.getPerson().getPesel()));
            }
            catch (NoResultException e1)
            {
            }

            userService.persist(user);
            return true;
        }
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getListOfUsers()
    {
        return userService.findAll();
    }

    @GET
    @Path("/{login}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserByLogin(@PathParam("login") String login)
    {
        return userService.findByLogin(login);
    }

    @PUT
    @Path("/password")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean updatePassword(User user){
        try{
            User u = userService.findById(user.getId());
            u.setPassword(user.getPassword());
            userService.update(u);
            return true;
        }
        catch(NoResultException e){
            return false;
        }
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean updateUser(User user)
    {
        try
        {
            userService.findById(user.getId());
            userService.update(user);
            return true;
        }
        catch (NoResultException e)
        {
            return false;
        }
    }

    @DELETE
    @Produces("application/json")
    @Path("/delete/{id}")
    public List<User> deleteUser(@PathParam("id") Long id)
    {
        userService.delete(id);
        return userService.findAll();
    }
}
