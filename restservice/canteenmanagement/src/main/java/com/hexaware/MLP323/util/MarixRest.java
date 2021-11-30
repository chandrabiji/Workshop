package com.hexaware.MLP323.util;

import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Produces;

import javax.ws.rs.core.Response;

@Path("/matrix")
public class MarixRest {



    @GET
    @Produces("text/html")
    public Response getResultByv(@MatrixParam("nameKey") String name, @MatrixParam("stateKey") String state){
        String op="Customer Name  :"+name+ "\nFrom :"+state;
        return Response.status(200).entity(op).build();
    }



    // http://localhost:18080/MLP323/api/matrix;nameKey=Omkar;stateKey=Maharashtra
}