package services;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CRUDService {

    public String getMethod()
    {
        return "Get";
    }

    public String postMethod()
    {
        return "Post";
    }
}
