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
    @Order(2)
    public void testParamMessageFromPropertyFile()
    {
        given().when().get("/hello/message")
                .then()
                .statusCode(200)
                .body(is("This is Greeting Message from Property File: message"));

    }

    @Test
    @Order(3)
    public  void testPostMethod(){
        given()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .when()
                .post("/hello/t2")
                .then()
//                .statusCode(Response.Status.CREATED.getStatusCode())
                .body(is("HardCoded Post method response"));
    }

    @Test
    @Order(3)
    public  void testDeleteMethod(){
        given()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .when()
                .delete("/hello/t2")
                .then()
//                .statusCode(Response.Status.CREATED.getStatusCode())
                .body(is("Delete Call was made using Service Method"));
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
        Assertions.assertEquals("HardCoded Post method response", exampleService.postRequest());
    }
    
    @Test
    @Order(4)
    public  void testPutMethodWithServiceInject()
    {
        Assertions.assertEquals("Put Call was made using Service Method", exampleService.putRequest());
    }
    
    @Test
    @Order(4)
    public  void testDeleteMethodWithServiceInject()
    {
        Assertions.assertEquals("Delete Call was made using Service Method", exampleService.deleteRequest());
    }


}
