package com.ojas.MLP323.util;

import javax.ws.rs.GET;
import javax.ws.rs.POST;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ojas.MLP323.factory.BillFactory;
import com.ojas.MLP323.model.Bill;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/Bill")
public class BillRest {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/count/{id}")
  public final int count(@PathParam("id") int cusId){
    return BillFactory.count(cusId);
  }





@POST
@Path("/createBill")
public static boolean insert(Bill c) {

  return BillFactory.insert(c);

}


@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("/showAllBills")
 public static Bill[] getAllBills(){
   return BillFactory.getAllBills();
 }

 @GET
 @Produces(MediaType.APPLICATION_JSON)
 @Path("/showBillsByCustomerId/{id}")
  public static Bill[] getBillsbyCustId(@PathParam("id") int id){
    return BillFactory.getBillsbyCustId(id);
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/showBillByCCartId/{id}")
   public static Bill getBillBycartId(@PathParam("id") String id){
     return BillFactory.getBillBycartId(id);
   }
}
