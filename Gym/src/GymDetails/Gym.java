package GymDetails;

import Users.Coach;
import Users.Customer.Customer;
import Users.Customer.Subscription;
import Users.SystemUser;

import java.util.ArrayList;

public class Gym {
    public String Name;
    private String Address;
    public String phoneNumber;
    public static ArrayList<Equipment> listOfEquipments = new ArrayList<>();
    public static ArrayList<Coach> listOfCoaches = new ArrayList<>();
    public static ArrayList<Customer> listOfCustomers = new ArrayList<>();
    public static ArrayList<SystemUser> listOfSystemUsers = new ArrayList<>();
    public static ArrayList<Subscription> listOfSubscriptions = new ArrayList<>();


    public Gym(String name, String address, String phoneNumber, ArrayList<Equipment> listOfEquipments, ArrayList<Coach> listOfCoaches, ArrayList<Customer> listOfCustomers, ArrayList<Subscription> listOfSubscriptions) {
        Name = name;
        Address = address;
        this.phoneNumber = phoneNumber;
        Gym.listOfEquipments = listOfEquipments;
        Gym.listOfCoaches = listOfCoaches;
        Gym.listOfCustomers = listOfCustomers;
        Gym.listOfSubscriptions = listOfSubscriptions;
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

}
