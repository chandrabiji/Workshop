package com.hexaware.MLP323.util;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.hexaware.MLP323.model.Offers;
import com.hexaware.MLP323.factory.BillFactory;
import com.hexaware.MLP323.factory.OfferFactory;




/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/offers")
public class OffersRest {
  /**
   * Returns Offers details.
   * @return the Offers details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/list")
  public final Offers[] listOffers() {
    final Offers[] Offers = OfferFactory.showAllOffers();
    return Offers;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/showByVendId/{vendid}")
  public final Offers[] showOffersByVenId(@PathParam("vendid") int vendid){
    return OfferFactory.showAllOffersByVendorId(vendid);
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/offerByOfferId/{ofId}")
  public final Offers offerbyofferId(@PathParam("foodid") int foodid){
    Offers Offers = OfferFactory.offerByOfferId(foodid);
    return Offers;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/countOffersOfCustomer/{customerId}/{offerid}")
  public static int countOfferForCustomers(@PathParam("customerId")int cust_id,@PathParam("offerid")String id) {
    return BillFactory.checkOfferCount(cust_id,id);
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/isPresent/{id}")
  public static Offers isPresent(@PathParam("id")String id ) {
    return OfferFactory.offerPresent(id);
  }




  @POST
  @Path("/createOffers")
  public static boolean createOffersItem(Offers m) {


    return OfferFactory.createOffers(m);

  }



  @DELETE
  @Path("/deleteOffer/{foodId}")
  public static boolean deleteOffers(@PathParam("foodId") int id) {
    return OfferFactory.deleteOffer(id);
  }


  @GET
  @Path("/getnextId")
  public static int last() {
    return (OfferFactory.getLastId()+1);
  }


}
