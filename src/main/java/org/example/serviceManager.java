package org.example;
import java.util.*;
public class serviceManager extends customerManager{
    static List<Service> services=new ArrayList<Service>();
    public static void addService(String name,double duration,double price)
    {
        Service new_service = new Service(name,duration,price);
        services.add(new_service);
    }

    public static void updateService(int index,String name,double duration,double price)
    {
        Service service = services.get(index);
        service.setName(name);
        service.setDuration(duration);
        service.setPrice(price);
    }

}
