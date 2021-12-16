package com.example;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import services.ExampleService;

import javax.inject.Inject;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class ExampleResourceTest {

    //BlackBox Test
    @Test
    @Order(1)
    public void testHelloEndpoint() {
        given()
                .when().get("/hello")
                .then()
                .statusCode(200)
                .body(is("Hello Mr/Mrs Hello RESTEasy"));
    }

    //BlackBox Test
    @Test
    @Order(2)
    public void testParamMessageFromPropertyFile()
    {
        given().when().get("/hello/message")
                .then()
                .statusCode(200)
                .body(is("{\"greeting\":\"This is Greeting Message from Property File:\",\"name\":\"message\",\"age\":\"22\"}"));

    }

    //BlackBox Test
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

    //BlackBox Test
    @Test
    @Order(4)
    public  void testDeleteMethod(){
        given()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .when()
                .delete("/hello/t2")
                .then()
//                .statusCode(Response.Status.CREATED.getStatusCode())
                .body(is("{\"deleteMethod\":\"Delete Call was made using Service Method\"}"));
    }

    @Inject
    ExampleService exampleService;

    //WhiteBox Test
    @Test
    public void testSumMethod()
    {
        final int sum = exampleService.sum(1,3);
        assertEquals(sum, 4);
    }

    //WhiteBox Test
    @Test
    public void testAsInjection()
    {
        assertEquals("Hello Mr/Mrs Anmol", exampleService.withParam("Anmol"));
    }

    //WhiteBox Test
    @Test
    @Order(3)
    public  void testPostMethodWithServiceInject()
    {
        assertEquals("HardCoded Post method response", exampleService.postRequest());
    }

    //WhiteBox Test
    @Test
    @Order(4)
    public  void testPutMethodWithServiceInject()
    {
        assertEquals("{\"putMethod\":\"Put Call was made using Service Method\"}", exampleService.putRequest());
    }

    //WhiteBox Test
    @Test
    @Order(4)
    public  void testDeleteMethodWithServiceInject()
    {
        assertEquals("{\"deleteMethod\":\"Delete Call was made using Service Method\"}", exampleService.deleteRequest());
    }


}
