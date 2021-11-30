package com.hexaware.MLP323.util;

import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;


@Path("/media")
public class MediaTypeDemo {



    @GET
    @Path("/plain")
    @Produces(MediaType.TEXT_PLAIN)
    public String plaintext(){
        return "Plain Text...";
    }

    @GET
    @Path("/html")
    @Produces(MediaType.TEXT_HTML)
    public String htmlText(){
        return "Plain Text...";
    }

    @GET
    @Path("/xml")
    @Produces(MediaType.TEXT_XML)
    public String xmlTest(){
        return "<employee><name>Omkar</name></employee>";
    }







    // http://localhost:18080/MLP323/api/media
}