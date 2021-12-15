package com.example;

import org.json.JSONObject;
import services.ExampleService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class ExampleResource {

//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    public String hello() {
//        return "Hello RESTEasy";
//    }


    @Inject
    ExampleService exampleService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return exampleService.withParam("Hello RESTEasy");

    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{name}")
    public String paramMessageFromPropertyFile(@PathParam("name") String name) {
        return exampleService.serviceParamMessageFromPropertyFile(name);
    }

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/t1/{name}")
//    public String withParamAndPath(@PathParam("name") String name) {
//        return exampleService.withParamAndConfigFile(name);
//    }

//    @POST
//    @Path("/t1")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String postOperation() {
//        return "It was Post Request without Using Service";
//    }

    @POST
    @Path("/t2")
    @Produces(MediaType.APPLICATION_JSON)
    public String postOperationWithService() {
        return exampleService.postRequest();
    }

    @PUT
    @Path("/t2")
    @Produces(MediaType.APPLICATION_JSON)
    public String putOperationWithService() {
        return exampleService.putRequest();
    }

    @DELETE
    @Path("/t2")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteOperationWithService() {
        return exampleService.deleteRequest();
    }

}