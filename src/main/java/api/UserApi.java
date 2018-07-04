package api;

import model.User;
import service.UserService;

import javax.persistence.NoResultException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
@Path("/users")
public class UserApi {
    private UserService userService=new UserService();
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean addUser(User user)
    {
        try
        {
            userService.findByUsername(user.getUsername());
            return false;
        }
        catch (NoResultException e)
        {
            user.setToken("user");
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
    @Path("/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserByUsername(@PathParam("username") String username)
    {
        return userService.findByUsername(username);
    }
}
