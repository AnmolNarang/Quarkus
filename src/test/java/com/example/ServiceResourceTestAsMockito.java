//package com.example;
//
//import io.quarkus.test.junit.mockito.InjectMock;
//import org.junit.jupiter.api.*;
//import org.mockito.Mockito;
//import services.ExampleService;
//import services.ExampleServiceMock;
//
//
//public class ServiceResourceTestAsMockito {
//
//    @InjectMock
//    ExampleService exampleService;
//
//    @BeforeEach
//    public void setup(){
//
//        exampleService.withParam("");
//        Mockito.when(exampleService.withParam("")).thenReturn("Hello Dummy");
//    }
//    @Test
//    @Order(1)
//    public void testMockTest() {
//        Assertions.assertEquals("Hello Dummy", exampleService.withParam(""));
//    }
//}
