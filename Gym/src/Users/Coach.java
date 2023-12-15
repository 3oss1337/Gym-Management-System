package Users;

import Users.Customer.Customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Coach extends Person {

    public int id;
    private int workingHours;   // per Day can't be more than 10H
    public static int coachId = 500;
    private List<Customer> customers;
    public Coach(String name, String password, String gender, String address, String phoneNumber, String email,int age) {
        super(name,password, gender, address,phoneNumber,email,age);
        incrementCoachId();
        this.customers=new ArrayList<>();
        this.id = coachId;

    }
    public Coach(String name) {
        super(name);
    }
    public static void incrementCoachId() {
        coachId++;
    }

    public List<Customer> getAllTrainees() {
        return customers;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getWorkingHours() {
        return workingHours;
    }
    public void setWorkingHours(int workingHours) {
        if(workingHours > 10)
        {
            System.out.println("Invalid working hours amount");
        }
        else
            this.workingHours = workingHours;
    }

    public void displayAllCustomers() {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
    public void addTrainee(Customer customer) {
        if (customers.size() < 10) {
            customers.add(customer);
            System.out.println("Trainee added: " + customer.getName());
        } else {
            System.out.println("Cannot add trainee. Coach already has the maximum number of trainees (10).");
        }
    }
    public void getTraineeDetailsByName(String customerName) { //Returns details of a certain customer with a coach

        boolean flag = false;
        for (Customer customer : customers) {
            flag = false;
            if (customer.name.trim().equalsIgnoreCase(customerName.trim())) {
                System.out.println("Match found for: " + customerName);
                System.out.println(customer);
                flag = true;
                break;
            }
        }
        if (flag == false) {
            System.out.println("No match found for " + customerName);
        }
    }
    public void getTraineesByGender(String gender) {
        for (Customer customer : customers) {
            if (customer.gender.trim().equalsIgnoreCase(gender.trim())) {
                System.out.println("The " + gender + " Customers are : ");
                System.out.println(customer);
            }
        }
    }

    @Override
    public void login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your UserName:");
        String userName = scanner.nextLine();
        System.out.println("Enter your password:");
        String password = scanner.nextLine();
    }

    @Override
    public void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello Captain " + getName());

        System.out.println("1. Show a list of my customers\n" +
                "2. Get the in-body history of a specific customer\n" +
                "3. Get all the details of a specific customer by his name\n" +
                "4. Show a list of all my female/male customers");

        System.out.println("Choose your choice");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                displayAllCustomers();
                break;
            case 2:
                //TODO call in-body history
                break;
            case 3:
                System.out.println("Enter trainee's name: ");
                String traineeName = scanner.nextLine();
                getTraineeDetailsByName(traineeName);
                break;
            case 4:
                System.out.println("Choose which gender to display male/female");
                String gender = scanner.nextLine();
                getTraineesByGender(gender);
                break;
            default:
                System.out.println("please enter a valid choice");
        }

    }
    @Override
    public void displayInfo() {
        System.out.println("Name:"+ this.name);
        System.out.println("Phone number:"+ this.phoneNumber);
        System.out.println("Gender:"+ this.gender);
        System.out.println("Mail:"+ this.email);

    }

    //TODO INBODY HISTORY
    @Override
    public void register(){}



}

