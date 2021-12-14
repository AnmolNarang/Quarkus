package com.example;

import services.ExampleServiceMock;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/sr")
public class ServiceResource {
    @Inject
    ExampleServiceMock service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String paramMessageFromPropertyFile() {
        return service.test() ;
    }

}
