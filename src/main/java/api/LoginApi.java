package api;
import model.Login;
import model.User;
import service.UserService;

import javax.persistence.NoResultException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/login")
public class LoginApi {
    private UserService userService=new UserService();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Login logIn(User user)
    {
        try
        {
            User local = userService.findByLoginAndPassword(user.getLogin(), user.getPassword());
            return new Login(local.getToken(),local.getLogin(),local.getPerson().getPesel());
        }
        catch (NoResultException e)
        {
            return null;
        }
    }
}
