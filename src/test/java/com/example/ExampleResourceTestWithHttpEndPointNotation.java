package com.example;


import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@TestHTTPEndpoint(ExampleResource.class)
public class ExampleResourceTestWithHttpEndPointNotation {

    @Test
    @Order(1)
    public void testHelloEndpoint() {
        given()
                .when().get()
                .then()
                .statusCode(200)
                .body(is("Hello RESTEasy"));
    }

//    @Test
//    @Order(2)
//    public void testDeleteEndpoint() {
//        given()
//                .body("")
//                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
//                .when()
//                .put()
//                .then()
////                .statusCode(200)
//                .body(is("Put Call was made using Service Method"));
//    }

}
