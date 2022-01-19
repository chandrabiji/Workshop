package com.ojas.MLP323.util;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ojas.MLP323.factory.VendorFactory;
import com.ojas.MLP323.model.Vendor;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/vendor")
public class VendorRest {
  /**
   * Returns Vendor details.
   * @return the Vendor details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/list")
  public final Vendor[] listVendor() {
    final Vendor[] Vendor = VendorFactory.allVendors();
    return Vendor;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/vendorbyvendid/{venid}")
  public final Vendor displayVendorByVendorId(@PathParam("venid") int vendid){
    return VendorFactory.displayVendorByVendorId(vendid);
  }

@PUT
@Path("/updateVendor")
public static boolean updateVendorDetails(Vendor c) {

  return VendorFactory.updateVendorDetails(c);

}


@POST
@Path("/createVendor")
public static boolean createVendorRecord(Vendor c) {

  return VendorFactory.createVendorRecord(c);

}



  @GET
  @Path("/loginVen/{userName}/{userPass}")
  public static int loginVendor(@PathParam("userName") String un, @PathParam("userPass") String up) {
    int data=-1;
    data=VendorFactory.loginVendor(un,up);
    return data;
    // if (data!=-1 && data!=0){
    //     return true;
    // }
    // else{
    //     return false;
    // }
  }


  @GET
  @Path("/checkVendor/{id}")
  public static boolean vendorExist(@PathParam("id") int id) {
    return VendorFactory.vendorExist(id);
  }

  @DELETE
  @Path("/deleteVendor/{id}")
  public static boolean deleteVendorRecord(@PathParam("id") int id) {
    return VendorFactory.deleteVendorRecord(id);
  }




  @GET
  @Path("/getnextId")
  public static int last() {
    return (VendorFactory.getLastId()+1);
  }


  @GET
  @Path("/isEmailPresent/{id}")
  public static boolean isPresent( @PathParam("id") String email){
    return VendorFactory.isEmailPresent(email);
  }

  @GET
  @Path("/getRatings/{id}")
  public static double getRatings( @PathParam("id") int id){
    return VendorFactory.getRatings(id);
  }


@PUT
@Path("/updateRatings/{id}/{rat}")
public static boolean setRatings( @PathParam("id") int id, @PathParam("rat") double rat) {

  return VendorFactory.setRatings(id,rat)==1?true:false;

}

@PUT
@Path("/updatePassword/{id}/{password}")
public static boolean updatePass(@PathParam("id") String id, @PathParam("password") String amt) {
  return VendorFactory.updatePassword(id,amt);
}


}
