package com.example;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.json.JSONObject;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import services.ExampleService;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ServiceResourceTestAsMockito {

    @InjectMock
    ExampleService exampleService;

    @BeforeEach
    public void setup() {
        Mockito.when(exampleService.postRequest()).thenReturn("A mock for Stuart");
        Mockito.when(exampleService.withParam("Hello RESTEasy")).thenReturn("Hello RESTEasy Mockito");

        JSONObject jo = new JSONObject();
        jo.put("deleteMethod", "Mockito Delete Method call");
        Mockito.when(exampleService.deleteRequest()).thenReturn(jo.toString());
    }

    @Test
    @Order(1)
    public void MockitoTest() {
        Assertions.assertEquals("A mock for Stuart", exampleService.postRequest());
    }

    @Test
    @Order(2)
    public void testHelloEndpointWithMockito() {
        given()
                .when().get("/hello")
                .then()
                .statusCode(200)
                .body(is("Hello RESTEasy Mockito"));
    }

    @Test
    @Order(3)
    public  void testDeleteMethodUsingMockito(){
        given()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .when()
                .delete("/hello/t2")
                .then()
//                .statusCode(Response.Status.CREATED.getStatusCode())
                .body(is("{\"deleteMethod\":\"Mockito Delete Method call\"}"));
    }

}
