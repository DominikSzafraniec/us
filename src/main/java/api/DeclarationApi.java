package api;

import model.Declaration;
import service.DeclarationService;

import javax.persistence.NoResultException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/declarations")
public class DeclarationApi {
    private DeclarationService declarationService=new DeclarationService();
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean addDeclaration(Declaration declaration){
        try
        {
            Declaration declaration1=declarationService.findById(declaration.getId());
            return false;
        }
        catch (NoResultException e)
        {
            declarationService.persist(declaration);
            return true;
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Declaration> getListOfDeclarations()
    {
        return declarationService.findAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/useronly/{pesel}")
    public List<Declaration> getListOfDeclarations(@PathParam("pesel") Long pesel)
    {
        return declarationService.findAllUserDeclaration(pesel);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean updateDeclaration(Declaration declaration)
    {
        try
        {
            declarationService.findById(declaration.getId());
            declarationService.update(declaration);
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
    public List<Declaration> deletedeclaration(@PathParam("id") Long id)
    {
        declarationService.delete(id);
        return declarationService.findAll();
    }
}
