package org.example;
import java.util.Date;
import java.io.Serializable;
import java.util.HashMap;

public class Appointment  implements Serializable {
    static HashMap<String,Double> membership_types=new HashMap<>();


    private Customer customer;
    private Service service;
    private Date date;
    private double total_price;

    public Appointment(Customer customer, Service service, Date date) {
        this.customer = customer;
        this.service = service;
        this.date = date;
        membership_types.put("silver", 0.1);
        membership_types.put("gold", 0.3);
        membership_types.put("platinum", 0.5);
        this.total_price = service.getPrice() - (membership_types.get(customer.getMembershipType()) * service.getPrice());
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "customer=" + customer +
                ", service=" + service +
                ", date=" + date +
                ", total_price=" + total_price +
                '}';
    }
}
