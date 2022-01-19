<<<<<<< HEAD
package com.ojas.MLP323.util;

import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;

import javax.ws.rs.core.Response;

@Path("/query")
public class QueryRest {



    @GET
    @Produces("text/html")
    public Response getResultByv(@QueryParam("nameKey") String name, @QueryParam("stateKey") String state){
        String op="Customer Name  :"+name+ "\nFrom :"+state;
        return Response.status(200).entity(op).build();
    }


    // http://localhost:8080/MLP319/api/query?nameKey=charan&stateKey=Maharashtra
=======
package com.ojas.MLP323.util;

import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;

import javax.ws.rs.core.Response;

@Path("/query")
public class QueryRest {



    @GET
    @Produces("text/html")
    public Response getResultByv(@QueryParam("nameKey") String name, @QueryParam("stateKey") String state){
        String op="Customer Name  :"+name+ "\nFrom :"+state;
        return Response.status(200).entity(op).build();
    }


    // http://localhost:8080/MLP319/api/query?nameKey=charan&stateKey=Maharashtra
>>>>>>> branch 'master' of https://github.com/chandrabiji/Workshop
}