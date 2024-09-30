package org.example;

import java.io.Serializable;
public class Customer implements Serializable {
    private String name;
    private String  phoneNumber;
    private String membershipType;
    public Customer(String name,String phoneNumber,String membershipType){
        this.name=name;
        this.phoneNumber=phoneNumber;
        this.membershipType=membershipType;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", membershipType='" + membershipType + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }
}
