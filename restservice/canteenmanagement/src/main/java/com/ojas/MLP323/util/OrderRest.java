package com.ojas.MLP323.util;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ojas.MLP323.factory.OrderFactory;
import com.ojas.MLP323.model.Order;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/Order")
public class OrderRest {
  /**
   * Returns Order details.
   * @return the Order details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/list")
  public final Order[] allOrders() {
    final Order[] Order = OrderFactory.allOrders();
    return Order;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/showOrdersByCustId/{cusId}")
  public final Order[] showOrdersByCustId(@PathParam("cusId") int cusId){
    return OrderFactory.showOrdersByCustId(cusId);
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/showOrdersByVendId/{id}")
  public final Order[] showOrdersByVendId(@PathParam("id") int id){
    return OrderFactory.showOrdersByVendId(id);
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/showOrdersByOrderId/{id}")
  public final Order showOrdersByOrderId(@PathParam("id") int id){
    return OrderFactory.showOrdersByOrderId(id);
  }



  //availedoffer : boolean

  //check offer

  //create offer

  // delete offer








  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/getPendingRecords/{id}")
  public final Order[] getPendingRecords(@PathParam("id") String cartid){
    return OrderFactory.getPendingRecords(cartid);
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/getCurrentDate")
  public final String getCurrentDate(){
    return OrderFactory.getCurrentDate();
  }


  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/getCurrentDateTime")
  public final String getCurrentDateTime(){
    return OrderFactory.getCurrentDateTime();
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/showCurrentOrdersByIdandComment/{id}/{comm}")
  public final Order[] showCurrentOrdersByIdandComment(@PathParam("id") int cusId,@PathParam("comm") String comm){
    return OrderFactory.showCurrentOrdersByIdandComment(cusId,comm);
  }

  @PUT
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/updateOrderStatus/{id}/{comm}")
  public final boolean updateOrderStatus(@PathParam("id") int cusId,@PathParam("comm") String comm){
      return OrderFactory.updateOrderStatus(cusId,comm);
  }




  @POST
  @Path("/createOrder")
  public static boolean createOrder(Order c) {

    return OrderFactory.createOrder(c);

  }


  @GET
  @Path("/getCartId/{name}/{id}")
  public static String cartIs(@PathParam("name") String name,@PathParam("id") String id) {

    return Integer.toString(OrderFactory.gethashCode(name, id));

  }

  @GET
  @Path("/isOrderPresent/{cartId}/{foodId}")
  public static int isPresntOrder(@PathParam("cartId") String cartId, @PathParam("foodId") int foodId){
    return OrderFactory.isOrderPresent(cartId,foodId);
  }



  @PUT
  @Path("/updatequantity/{orderid}/{quantity}/{price}")
  public final boolean updateItemQuantityandPrice(@PathParam("orderid") int id, @PathParam("quantity") int quantity,@PathParam("price") double price ){
    return OrderFactory.updateQuantityandPrice(id,quantity,price);
  }



  // @GET
  // @Produces(MediaType.APPLICATION_JSON)
  // @Path("/offerUsed/{id}/{offer}")
  // public final int getOfferUsedCount(@PathParam("offer") String offer,@PathParam("id") int id){
  //   return OfferFactory.checkOfferCount(id,offer);
  // }



}
