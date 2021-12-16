package services;


import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.json.JSONObject;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ExampleService {
    public JSONObject jo;

    public String withParam(String name) {
        return "Hello Mr/Mrs " + name;
    }


    @ConfigProperty(name = "greeting")
    private String greeting;

    public String serviceParamMessageFromPropertyFile(String name) {
        jo = new JSONObject();
        jo.put("greeting", greeting);
        jo.put("age", "22");
        jo.put("name", name);
        return jo.toString();
    }

    public String postRequest() {
        return "HardCoded Post method response";
    }

    public String getSum(String json)
    {
        jo = new JSONObject(json);
        int num1 = Integer.parseInt((String) jo.get("num1"));
        int num2 = Integer.parseInt((String) jo.get("num2"));
        jo.put("sum", sum(num1,num2));
        return jo.toString();
    }

    @ConfigProperty(name = "putMethodResponse")
    private String putMethodResponse;

    public String putRequest() {
        jo = new JSONObject();
        jo.put("putMethod", putMethodResponse);
        return jo.toString();
    }

    @ConfigProperty(name = "deleteMethodResponse")
    private String deleteMethodResponse;

    public String deleteRequest() {
        jo = new JSONObject();
        jo.put("deleteMethod", deleteMethodResponse);
        return jo.toString();
    }


    public int sum(int i, int j) {
        return i + j;
    }


//    @ConfigProperty(name = "property_coming_from_properyFile")
//    private String property_coming_from_properyFile;
//
//    public String comingFromProperty(String name){
//        return property_coming_from_properyFile + " " + name;
//    }
}