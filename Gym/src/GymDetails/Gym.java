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

    public static void saveObject(Serializable obj, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath, true))) {
            // Check if the object is serializable before attempting to write
            if (obj instanceof Serializable) {
                oos.writeObject(obj);
                System.out.println("Object saved to " + filePath);
            } else {
                System.out.println("Object is not serializable. Cannot be saved.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object loadObject(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            try {
                return ois.readObject();
            } catch (EOFException e) {
                System.out.println("End of file reached. No object to load.");
                return null;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
