package com.example;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import services.ExampleServiceMock;

import javax.inject.Inject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ServiceResourceTest {

    @Test
    @Order(1)
    public void testStubTest() {
        given()
                .when().get("/sr")
                .then()
                .statusCode(200)
                .body(is("Hello Dummy"));
    }

    @Inject
    ExampleServiceMock exampleServiceMock;
    @Test
    @Order(2)
    public void whiteBoxTest() {
        assert(exampleServiceMock.test().contains("Hello"));
        assert (exampleServiceMock.method2().contains("Test Mock"));

    }


}
