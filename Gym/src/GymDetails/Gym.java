package GymDetails;

import Users.Admin;
import Users.Coach;
import Users.Customer.Customer;
import Users.Customer.Subscription;
import Users.SystemUser;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Gym implements Serializable{
    public String Name;
    private String Address;
    public String phoneNumber;
    public static ArrayList<Equipment> listOfEquipments = new ArrayList<>();
    public static ArrayList<Coach> listOfCoaches = new ArrayList<>();
    public static ArrayList<Customer> listOfCustomers = new ArrayList<>();
    public static ArrayList<SystemUser> listOfSystemUsers = new ArrayList<>();
    public static ArrayList<Subscription> listOfSubscriptions = new ArrayList<>();


    public Gym(String name, String address, String phoneNumber) {
        Name = name;
        Address = address;
        this.phoneNumber = phoneNumber;
        /*Gym.listOfEquipments = listOfEquipments;
        Gym.listOfCoaches = listOfCoaches;
        Gym.listOfCustomers = listOfCustomers;
        Gym.listOfSubscriptions = listOfSubscriptions;*/
    }


    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public ArrayList<Subscription> getListOfSubscriptions() {
        return listOfSubscriptions;
    }

    public void setListOfSubscriptions(ArrayList<Subscription> listOfSubscriptions) {
        Gym.listOfSubscriptions = listOfSubscriptions;
    }

    public ArrayList<Customer> getListOfCustomers() {
        return listOfCustomers;
    }

    public void setListOfCustomers(ArrayList<Customer> listOfCustomers) {
        Gym.listOfCustomers = listOfCustomers;
    }

    public static void addEquipment(Equipment equipment) {
        listOfEquipments.add(equipment);
    }

    public void removeEquipment(Equipment equipment) {
        listOfEquipments.remove(equipment);
    }

    public static void addSubscription(Subscription subscription) {
        listOfSubscriptions.add(subscription);
    }

    public void removeSubscription(Subscription subscription) {
        listOfSubscriptions.remove(subscription);
    }

    public static void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Log in as ADMIN\n" + "2. Log in as COACH\n" + "3. Log in as TRAINEE\n" + "4. Log in as receptionist");

        System.out.println("Choose your choice");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                Admin admin = new Admin();
                admin.login();
                admin.menu();
                break;
            case 2:
                Coach coach = new Coach();
                coach.login();
                coach.menu();
                break;
            case 3:
                Customer customer = new Customer();
                customer.login();
                customer.menu();
                break;
            case 4:
                SystemUser systemUser = new SystemUser();
                systemUser.login();
                systemUser.menu();
                break;
            default:
                System.out.println("please enter a valid choice");
        }
    }

    public static void saveToFile(ArrayList<?> arrayList, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(arrayList);
            System.out.println("Objects written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<?> loadFromFile(String filePath) {
        File file = new File(filePath);
        ArrayList<?> arrayList = null;
        if (file.exists()) {
            // If the file exists, read the stored objects from the file
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
                ArrayList<?> readPersonList = (ArrayList<?>) ois.readObject();


                /*System.out.println("Already Saved Persons:");
                for (Customer customer : readPersonList) {
                    System.out.println(customer);
                }*/

                System.out.println("Objects read from file successfully.");

                return readPersonList;
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void displayCoaches (ArrayList<Coach> arrayList){
        System.out.println("Already Saved Coaches:");
                for (Coach coach : arrayList) {
                    System.out.println(coach);
                }
    }

    public static void displayCustomers (ArrayList<Customer> arrayList){
        System.out.println("Already Saved Customers:");
        for (Customer customer : arrayList) {
            System.out.println(customer);
        }
    }

    public static void displayEquipments (ArrayList<Equipment> arrayList){
        System.out.println("Already Saved Equipments:");
        for (Equipment equipment : arrayList) {
            System.out.println(equipment);
        }
    }

    public static void displaySystemUsers (ArrayList<SystemUser> arrayList){
        System.out.println("Already Saved Receptionists:");
        for (SystemUser systemUser : arrayList) {
            System.out.println(systemUser);
        }
    }

}
