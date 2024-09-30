package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.example.customerManager;

import static org.junit.jupiter.api.Assertions.*;

class customerManagerTest {
    customerManager customermanager;
    @BeforeEach
    public void setUp(){
       customermanager = new customerManager();
    }
    @Test
    void validatePhoneNumber() {
        Assertions.assertTrue(customerManager.validatePhoneNumber("562151253"));

    }
    @Test
    void shouldAddCustomerandUpdatetest() {
        customermanager.addCustomer("Manar Atalla", "333456784", "gold"); // Invalid number, should not be added
        customermanager.addCustomer("Sara Ismail", "567734511", "silver");
        customermanager.addCustomer("Aseel Ahmed","567899023","silver");
        customermanager.addCustomer("Ezz Atallah","592661915","gold");
        // Valid numbers should be added
        // Since "Manar Atalla" has an invalid number, it should not be added therefore the size should be 3
        Assertions.assertEquals(3, customermanager.customers.size());
        customermanager.updateCustomer(2,"Ezz Atallah","592661915","platinum");
        Assertions.assertEquals("platinum",customermanager.customers.get(2).getMembershipType());
        //if the update method work


    }


    @Test
    void delete() {
        customermanager.delete(customermanager.customers, 1);
        assertEquals(2, customermanager.customers.size());

    }

    @AfterEach
    public void print(){
        System.out.println("after one test");
    }
}