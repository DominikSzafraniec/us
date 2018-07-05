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
        System.out.println("ID "+address.getId());
        try
        {
            Address address1=addressService.findAddress(address);
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
    public List<Address> getListOfAddresses()
    {
        return addressService.findAll();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean updateAddress(Address address)
    {
        try
        {
            addressService.findById(address.getId());
            addressService.update(address);
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
    public List<Address> deleteAddress(@PathParam("id") Long id)
    {
        addressService.delete(id);
        return addressService.findAll();
    }
}
