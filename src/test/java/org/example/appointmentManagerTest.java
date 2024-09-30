package org.example;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class appointmentmanagertest {

    @Test
    void addAppointment() {
        // Add an a70.00ppointment with a test customer and service
        appointmentManager.addAppointment(new Customer("testcustomer", "592151253", "gold"),
                new Service("haircut", 2.5, 150),
                new Date());
        Appointment appointment = appointmentManager.appointments.get(0);
                assertEquals(105, appointment.getTotal_price());

        }


    @ParameterizedTest
    @ValueSource(ints={2,5,4,5,3,2})
    void validateDate(int hour) {
        assertTrue(appointmentManager.validateDate("2024-12-03",hour));
        //the hour 5:00 is unavailable and 2 because they're already been booked
    }

}