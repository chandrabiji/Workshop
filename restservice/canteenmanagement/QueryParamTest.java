package com.hexaware.MLP323.util;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;



@Path("/query")
public class QueryParamTest {



 @GET
 @Produces("text/html")
 public Response getResultByPassingValue(@QueryParam("nameKey")String name,@QueryParam("countryKey")String country) {
   String output = "Customer Name : "+name+" Country : "+country+"";
   return Response.status(200).entity(output).build();
 }



}
