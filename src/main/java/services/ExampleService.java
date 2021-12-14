package services;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ExampleService {
    public String withParam(String name){
        return "Hello Mr/Mrs " + name;
    }

    @ConfigProperty(name = "greeting")
    private String greeting;

    public String withParamAndConfigFile(String name){
        return greeting + " " + name;
    }

    public String postRequest(){
        return "Post method response from Service Call";
    }

    @ConfigProperty(name="putMethodResponse")
    private String putMethodResponse;
    public String putRequest(){
        return putMethodResponse;
    }

    @ConfigProperty(name="deleteMethodResponse")
    private String deleteMethodResponse;
    public String deleteRequest(){
        return deleteMethodResponse;
    }

//    @ConfigProperty(name = "property_coming_from_properyFile")
//    private String property_coming_from_properyFile;
//
//    public String comingFromProperty(String name){
//        return property_coming_from_properyFile + " " + name;
//    }
}