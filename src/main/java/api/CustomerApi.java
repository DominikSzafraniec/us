package api;

import entity.Customer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/customers")
public class CustomerApi {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();

        Customer c1 = new Customer();
        c1.setId("1");
        c1.setLogin("l1");
        c1.setPassword("p1");
        c1.setToken("t1");
        Customer c2 = new Customer();
        c2.setId("2");
        c2.setLogin("c2");
        c2.setPassword("c2");
        c2.setToken("c2");
        Customer c3 = new Customer();
        c3.setId("3");
        c3.setLogin("c3");
        c3.setPassword("c3");
        c3.setToken("c3");

        customers.add(c1);
        customers.add(c2);
        customers.add(c3);

        return customers;
    }

}
