package GymDetails;

import Users.Coach;
import Users.Customer.Customer;
import Users.Customer.Subscription;

import java.util.ArrayList;

public class Gym {
    public String Name;
    private String Address;
    public String phoneNumber;
    public static ArrayList<Equipment> sportEquipment= new ArrayList<>();
    public static ArrayList<Coach> listOfCoaches= new ArrayList<>();
    protected static ArrayList<Customer> listOfCustomers=new ArrayList<>();
    protected static ArrayList<Subscription> listOfSubscriptions=new ArrayList<>();


    public Gym(String name, String address, String phoneNumber, ArrayList<Equipment> sportEquipment, ArrayList<Coach> listOfCoaches, ArrayList<Customer> listOfCustomers, ArrayList<Subscription> listOfSubscriptions) {
        Name = name;
        Address = address;
        this.phoneNumber = phoneNumber;
        Gym.sportEquipment = sportEquipment;
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
        sportEquipment.add(equipment);
    }

    public void removeEquipment(Equipment equipment) {
        sportEquipment.remove(equipment);
    }
    public static void addSubscription(Subscription subscription) {
        listOfSubscriptions.add(subscription);
    }

    public void removeSubscription(Subscription subscription) {
        listOfSubscriptions.remove(subscription);
    }

}
