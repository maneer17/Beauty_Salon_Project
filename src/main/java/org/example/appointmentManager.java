package org.example;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class appointmentManager extends customerManager
{
    public static List<Appointment> appointments = new ArrayList<Appointment>();
    static HashMap<String,HashSet<Integer>>appointment_map=new HashMap<String, HashSet<Integer>>();

    public static void addAppointment(Customer customer, Service service,Date date)
    {
        Appointment appointment = new Appointment(customer,service,date);
        appointments.add(appointment);

    }

    public static boolean validateDate(String date,int hour){
        HashSet<Integer>hours=new HashSet<Integer>();
        if(appointment_map.containsKey(date)){
            hours=appointment_map.get(date);
            return hours.add(hour);
        }
        else{
            hours.add(hour);
            appointment_map.put(date,hours);
            return true;
        }
    }

    public static void updateAppointment(int appointment_index,int customer_index,int service_index,Date date)
    {
        Appointment appointment=appointments.get(appointment_index);
        Customer customer = customers.get(customer_index);
        appointment.setCustomer(customer);
        Service service = serviceManager.services.get(service_index);
        appointment.setService(service);
        appointment.setDate(date);

    }
    public static void updateAppointmentDate(Date date,Appointment appointment){
        appointment.setDate(date);

    }

    public static <E> void delete(int index){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date=appointments.get(index).getDate();
        String formattedDate = formatter.format(date);
        int hour=date.getHours();
        appointment_map.get(formattedDate).remove(hour);
        delete(appointments,index);
    }


}

