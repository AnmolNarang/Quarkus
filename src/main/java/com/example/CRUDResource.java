package com.example;

import services.CRUDService;
import services.ExampleService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/crud")
public class CRUDResource {

    @Inject
    CRUDService crudService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String get() {
        return crudService.getMethod();

    }

    @POST
    @Path("/users")
    @Produces(MediaType.TEXT_PLAIN)
    public String post() {
        return crudService.postMethod();

    }
}
