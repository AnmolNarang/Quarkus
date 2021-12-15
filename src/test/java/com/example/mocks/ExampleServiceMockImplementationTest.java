package com.example.mocks;

import io.quarkus.test.Mock;
import services.ExampleServiceMock;

@Mock
public class ExampleServiceMockImplementationTest implements ExampleServiceMock {
    @Override
    public String test() {
        return "Hello Dummy";
    }

    @Override
    public String method2() {
        return "Test Mock";
    }
}
