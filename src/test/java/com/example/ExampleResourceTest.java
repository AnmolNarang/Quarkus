package com.example;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.internal.common.assertion.Assertion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import services.ExampleService;

import javax.inject.Inject;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ExampleResourceTest {

    @Test
    @Order(1)
    public void testHelloEndpoint() {
        given()
                .when().get("/hello")
                .then()
                .statusCode(200)
                .body(is("Hello RESTEasy"));
    }

    @Test
    public void  testPathWithConfig()
    {
        given().when().get("/hello/t1/message")
                .then()
                .statusCode(200)
                .body(is("Welcome!! message"));

    }

    @Test
    @Order(2)
    public  void testPostMethod(){
        given()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .when()
                .post("/hello/t2")
                .then()
//                .statusCode(Response.Status.CREATED.getStatusCode())
                .body(is("Post method response from Service Call"));
    }

    @Inject
    ExampleService exampleService;

    @Test
    public void testAsInjection()
    {
        Assertions.assertEquals("Hello Mr/Mrs Anmol", exampleService.withParam("Anmol"));
    }

    @Test
    @Order(3)
    public  void testPostMethodWithServiceInject()
    {
        Assertions.assertEquals("Post method response from Service Call", exampleService.postRequest());
    }


}