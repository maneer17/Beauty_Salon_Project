package org.example;
import java.text.ParseException;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(System.in);  // Single Scanner for all input
        int choice;

        do {
            // Display the menu
            System.out.println("\n===== Beauty Salon Management System =====");
            System.out.println("1. Add Customer");
            System.out.println("2. Update Customer");
            System.out.println("3. Delete Customer");
            System.out.println("4. Add Service");
            System.out.println("5. Update Service");
            System.out.println("6. Delete Service");
            System.out.println("7. Add Appointment");
            System.out.println("8. View Customers");
            System.out.println("9. View Services");
            System.out.println("10. View Appointments");
            System.out.println("11. Update an Appointment Entirely");
            System.out.println("12. Update an Appointment Date and hour");
            System.out.println("13. Exit from the program");
            System.out.println("14. Order a customers data file ");
            System.out.println("15. Order a services data file ");
            System.out.println("16. Order Appointments data file ");
            System.out.print("Enter your choice (1-11): ");
            choice = 0;
            while (true) {
                try {
                    choice = Integer.parseInt(input.nextLine()); // Read input and convert to int
                    if (choice >= 1 && choice <= 16) {
                        break; // Valid choice, break the loop
                    } else {
                        System.out.println("Please enter a number between 1 and 16.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }
            switch (choice) {
                case 1:
                    // Add customer
                    System.out.println("Enter the new name:");
                    String name = input.nextLine();
                    System.out.println("Enter the new phone number:");
                    String phone = input.nextLine();
                    while(!customerManager.validatePhoneNumber(phone)){
                        System.out.println("please Enter a valid phone number it must be 9 characters length and starts with 59 or 56");
                        phone=input.nextLine();}

                    System.out.println("Enter the membership type (silver, gold, platinum):");
                    String membership = input.nextLine();
                    customerManager.addCustomer(name, phone, membership);
                    break;

                case 2:
                    // Update customer
                    customerManager.view(customerManager.customers);
                    System.out.println("Which one do you want to update? Please enter the index:");
                    int index = input.nextInt();
                    input.nextLine();  
                    System.out.println("Enter the new name:");
                    String new_name = input.nextLine();
                    System.out.println("Enter the new phone number:");
                    String new_phone = input.nextLine();
                    System.out.println("Enter the new membership type:");
                    String new_membership = input.nextLine();
                    customerManager.updateCustomer(index - 1, new_name, new_phone, new_membership);
                    break;

                case 3:
                    // Delete customer
                    customerManager.view(customerManager.customers);
                    System.out.println("Which customer would you like to delete? Enter the index:");
                    int deleteIndex = input.nextInt();
                    input.nextLine();  // Consume leftover newline
                    customerManager.delete(customerManager.customers, deleteIndex - 1);
                    break;

                case 4:
                    // Add service
                    System.out.println("Enter the service name:");
                    String serviceName = input.nextLine();
                    System.out.println("Enter the service duration in minutes:");
                    double duration = input.nextDouble();
                    System.out.println("Enter the service price:");
                    double price = input.nextDouble();
                    input.nextLine();  
                    serviceManager.addService(serviceName, duration, price);
                    break;

                case 5:
                    // Update service
                    serviceManager.view(serviceManager.services);
                    System.out.println("Enter the index of the service to update:");
                    int serviceIndex = input.nextInt();
                    input.nextLine();  // Consume leftover newline
                    System.out.println("Enter the new service name:");
                    String newServiceName = input.nextLine();
                    System.out.println("Enter the new service duration:");
                    double newDuration = input.nextDouble();
                    System.out.println("Enter the new service price:");
                    double newPrice = input.nextDouble();
                    input.nextLine();  // Consume leftover newline
                    serviceManager.updateService(serviceIndex - 1, newServiceName, newDuration, newPrice);
                    break;

                case 6:
                    // Delete service
                    serviceManager.view(serviceManager.services);
                    System.out.println("Which service would you like to delete? Enter the index:");
                    int serviceDeleteIndex = input.nextInt();
                    input.nextLine();  // Consume leftover newline
                    serviceManager.delete(serviceManager.services, serviceDeleteIndex - 1);
                    break;

                case 7:
                    System.out.println("please Select the index of customer you want to add the appointment for : ");
                    appointmentManager.view(customerManager.customers);
                    Customer customer = customerManager.customers.get(input.nextInt() - 1);
                    System.out.println("please Select the index of service you want to add the appointment for : ");
                    appointmentManager.view(serviceManager.services);
                    Service service = serviceManager.services.get(input.nextInt() - 1);
                    System.out.println("Enter the data of your appointment in this format : yyyy-MM-dd : ");
                    Scanner parser = new Scanner(input.next());
                    String date=parser.next();
                    System.out.println("this is the busy hours for this date , please enter a non busy hour from 9:00 to 5:00");
                    System.out.println(appointmentManager.appointment_map.get(date));
                    int hour= input.nextInt();
                    while(!appointmentManager.validateDate(date,hour)){
                        System.out.println("please enter an available hour ");
                        hour=input.nextInt();
                    }
                    Date final_date = new SimpleDateFormat("yyyy-MM-dd-hh").parse(date+"-"+hour);
                    appointmentManager.addAppointment(customer,service,final_date);
                    break;
                


                case 8:
                    // View customers
                    customerManager.view(customerManager.customers);
                    break;

                case 9:
                    // View services
                    serviceManager.view(serviceManager.services);
                    break;

                case 10:
                    // View appointments
                    appointmentManager.view(appointmentManager.appointments);
                    break;
                case 11 :
                    System.out.println("please type the index of the appointment you want to update ");
                    appointmentManager.view(appointmentManager.appointments);
                    int appindex=input.nextInt();
                    System.out.println("Please Enter the index of customer you want to update to for this appointment : ");
                    customerManager.view(customerManager.customers);
                    int customerIndex =input.nextInt();
                    System.out.println("please Select the index of service you want to add the appointment for : ");
                    serviceManager.view(serviceManager.services);
                    int serviceindex=input.nextInt();
                    System.out.println("Enter the new  date of your appointment in this format : yyyy-MM-dd : ");
                    Scanner update_parser= new Scanner(input.next());
                    String updated_date=update_parser.next();
                    System.out.println("this is the busy hours for this date , please enter a non busy hour from 9:00 to 5:00");
                    System.out.println(appointmentManager.appointment_map.get(updated_date));
                    int updated_hour= input.nextInt();
                    while(!appointmentManager.validateDate(updated_date,updated_hour)){
                        System.out.println("please enter an available hour ");
                        updated_hour=input.nextInt();
                    }
                    Date final_updated_date = new SimpleDateFormat("yyyy-MM-dd-hh").parse(updated_date+"-"+updated_hour);
                    appointmentManager.updateAppointment(appindex-1,customerIndex-1,serviceindex-1,final_updated_date);
                    break;
                case 12 :
                    System.out.println("please type the index of the appointment you want to update ");
                    appointmentManager.view(appointmentManager.appointments);
                    int appointment_index=input.nextInt();
                    Appointment appointment=appointmentManager.appointments.get(appointment_index-1);
                    System.out.println("Enter the new  date of your appointment in this format : yyyy-MM-dd : ");
                    Scanner updateParser= new Scanner(input.next());
                    String updatedDate=updateParser.next();
                    System.out.println("this is the busy hours for this date , please enter a non busy hour from 9:00 to 5:00");
                    System.out.println(appointmentManager.appointment_map.get(updatedDate));
                    int updatedHour= input.nextInt();
                    while(!appointmentManager.validateDate(updatedDate,updatedHour)){
                        System.out.println("please enter an available hour ");
                        updatedHour=input.nextInt();
                    }
                    Date final_updatedDate = new SimpleDateFormat("yyyy-MM-dd-hh").parse(updatedDate+"-"+updatedHour);
                    appointmentManager.updateAppointmentDate(final_updatedDate,appointment);
                    break;

                case 13:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                case 14 :
                    customerManager.saveList(customerManager.customers,"customers");
                    break;
                case 15 :
                    serviceManager.saveList(serviceManager.services,"services");
                    break;
                case 16:
                    appointmentManager.saveList(appointmentManager.appointments,"appointments");
                    break;
                default:
                    System.out.println("Invalid choice! Please select a valid option.");
            }
        } while (choice != 13);

        input.close();
    }
}
