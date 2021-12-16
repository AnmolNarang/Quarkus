package com.example;

import org.json.JSONObject;
import services.ExampleService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class ExampleResource {

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

    @POST
    @Path("/t2")
    @Produces(MediaType.APPLICATION_JSON)
    public String postOperationWithService() {
        return exampleService.postRequest();
    }

    @POST
    @Path("/v3")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getSumOfTwo() {
        return exampleService.getSum("{\"num1\":\"1\",\"num2\":\"2\"}");
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