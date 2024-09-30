package org.example;

import java.io.Serializable;
public class Service implements Serializable {
    private String name;
    private double duration;
    private double price;

    public Service(String name,double duration,double price) {
        this.name = name;
        this.duration=duration;
        this.price=price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Service{" +
                "name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", price=" + price +
                '}';
    }
}

