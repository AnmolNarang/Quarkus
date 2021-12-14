package services;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ExampleServiceMockImplementation implements ExampleServiceMock {
    @Override
    public String test() {
        return "Hello";
    }

}
