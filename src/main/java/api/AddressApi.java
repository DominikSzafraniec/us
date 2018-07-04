package api;

import model.Address;
import service.AddressService;

import javax.persistence.NoResultException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/addresses")
public class AddressApi {
    private AddressService addressService=new AddressService();
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean addAddress(Address address){
        try
        {
            addressService.findById(address.getId());
            return false;
        }
        catch (NoResultException e)
        {
            addressService.persist(address);
            return true;
        }
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Address> getListOfPerson()
    {
        return addressService.findAll();
    }

}
