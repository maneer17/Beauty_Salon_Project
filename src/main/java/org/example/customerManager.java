package org.example;
import java.io.*;
import java.util.*;
public class customerManager {
    static List<Customer> customers = new ArrayList<Customer>();

    public static void addCustomer(String name,String phone, String membership)
    {

        Customer newCustomer=new Customer(name,phone,membership);
        if (customerManager.validatePhoneNumber(phone)){
            customers.add(newCustomer);
    }}
    public static boolean validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            return false;
        }
        return (phoneNumber.length() == 9) &&
                (phoneNumber.startsWith("59") || phoneNumber.startsWith("56"));
    }




    public static void updateCustomer(int index,String name,String phone,String membership)
    {
        Customer customer=customers.get(index);
        customer.setName(name);
        customer.setPhoneNumber(phone);
        customer.setMembershipType(membership);
    }

    public static <E>void view (List<E>list)
    {
        System.out.println("Here are the list of all items: ");
        for(int i=0 ,j=1;i< list.size();++i,++j)
            System.out.println(j+"-" + list.get(i));
    }

    public static <E> void delete(List<E>list,int index){
        view(list);
        list.remove(index);
    }

    public static <E> void saveList(List<E> list,String file_name) {

        try {
            FileOutputStream fos = new FileOutputStream(file_name+".ser");
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        try{
            FileInputStream fis=new FileInputStream(file_name+".ser");
            ObjectInputStream ois=new ObjectInputStream(fis);
            List obj=(List)ois.readObject();
            ois.close();
            PrintWriter file=new PrintWriter(file_name+".txt");
            file.println(obj);
            file.close();
        }
        catch (IOException e){
            System.out.println("error opening the file ");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

