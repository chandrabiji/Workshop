package com.hexaware.MLP323.util;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.hexaware.MLP323.model.Customer;
import com.hexaware.MLP323.factory.CustomerFactory;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/customer")
public class CustomerRest {
  /**
   * Returns Customer details.
   * @return the Customer details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/list")
  public final Customer[] listCustomer() {
    final Customer[] Customer = CustomerFactory.showFullCustomer();
    return Customer;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/Customerbycustid/{custId}")
  public final Customer showCustomerByCustomerId(@PathParam("custId") int vendid){
    return CustomerFactory.customerByCustId(vendid);
  }

@PUT
@Path("/updateCustomer")
public static boolean updateCustomer(Customer c) {

  return CustomerFactory.updateCustRec(c);

}


@POST
@Path("/createCustomer")
public static boolean createCustomer(Customer c) {

  return CustomerFactory.createNewCust(c);

}

  @PUT
  @Path("/updateAmount/{id}/{amount}")
  public static boolean updateAmount(@PathParam("id") int id, @PathParam("amount") double amt) {
    return CustomerFactory.updateAmount(id,amt);
  }


  @GET
  @Path("/Login/{userName}/{userPass}")
  public static int loginCustomer(@PathParam("userName") String un, @PathParam("userPass") String up) {
    int data=-1;
    data=CustomerFactory.loginCustomer(un,up);
    // if (data!=-1 && data!=0){
    //     return true;
    // }
    // else{
    //     return false;
    // }
    return data;
  }


  @GET
  @Path("/checkUserIdExist/{id}")
  public static boolean checkUserId(@PathParam("id") int id) {
    if (CustomerFactory.checkUserId(id)){
        return true;
    }
    else{
        return false;
    }
  }

  @DELETE
  @Path("/delete/{id}")
  public static boolean delete(@PathParam("id") int id) {
    if (CustomerFactory.deleteCustomerRe(id)){
        return true;
    }
    else{
        return false;
    }
  }

  @GET
  @Path("/getnextId")
  public static int last() {
    return (CustomerFactory.getLastId()+1);
  }

  @GET
  @Path("/isEmailPresent/{id}")
  public static boolean isPresent(final @PathParam("id") String email){
    return CustomerFactory.isEmailPresent(email);
  }



  @GET
  @Path("/getAllMails")
  public static String[] getAllMails(){
    return CustomerFactory.getAllMails();
  }





  @PUT
  @Path("/updatePassword/{id}/{password}")
  public static boolean updatePass(@PathParam("id") String id, @PathParam("password") String amt) {
    return CustomerFactory.updatePassword(id,amt);
  }


}
