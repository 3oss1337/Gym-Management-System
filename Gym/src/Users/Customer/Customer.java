package Users.Customer;

import GymDetails.Equipment;
import GymDetails.Gym;
import Users.Coach;
import Users.Person;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static GymDetails.Gym.listOfCoaches;
import static GymDetails.Gym.listOfEquipments;

public class Customer extends Person implements Serializable {
    private int id;
    public InBody inBody;
    public static List<Subscription> subscriptions;
    public Subscription subscription;
    private List<InBody> inBodies;
    LocalDate lastInBodyDate;
    public static int customerId = 0;

    public static void incrementCustomerId() {
        customerId++;
    }

    public Customer() {
    }

    public Customer(String name, String password, String gender, String address, String phoneNumber, String email, int age, InBody inBody, Subscription subscription) {
        super(name, password, gender, address, phoneNumber, email, age);
        this.inBody = inBody;
        this.subscription = subscription;
    }

    public List<InBody> getInBodies() {
        return inBodies;
    }

    public void setInBodies(List<InBody> inBodies) {
        this.inBodies = inBodies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer(String name) {
        super(name);
    }

    public LocalDate getLastInBodyDate() {
        return lastInBodyDate;
    }

    public void addToInBodyHistory(InBody Inbody) {
        inBodies.add(Inbody);
    }

    public void performInBody(InBody inBody) {
        if (inBody.canPerformInBody(this)) {
            inBodies.add(inBody);
            lastInBodyDate = LocalDate.now();
            System.out.println("InBody analysis performed successfully for " + name);
        } else {
            System.out.println("Sorry, you can perform an InBody analysis only once every 30 days.");
        }
    }

    public void displayAssignedCoachInfo(Customer customer) {
        for (Coach coach : listOfCoaches) {
            if (customer.subscription.getCoachId() == coach.id) {
                System.out.println(coach.id);

            }
        }
    }

    public void displayGymEquipment() {
        for (Equipment equipment : listOfEquipments) {
            equipment.displayDetails();
        }
    }

    public void displayMemberShipDetails(Customer customer) {
        customer.subscription.getMembership().display();
    }

    public void chooseYourDreamBody() {
        inBody.knowNeeded(this);
    }

    @Override
    public void displayInfo() {
        System.out.println("Name:" + this.name);
        System.out.println("Phone number:" + this.phoneNumber);
        System.out.println("Gender:" + this.gender);
        System.out.println("Mail:" + this.email);
        System.out.println("ID:" + this.id);
    }

    @Override
    public void login() {

        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your UserName:");
            String userName = scanner.nextLine();
            System.out.println("Enter your password:");
            String password = scanner.nextLine();

            boolean flag = false;

            for (Customer customer : Gym.listOfCustomers) {
                if (customer.getName().equalsIgnoreCase(userName) && customer.getPassword().equals(password)) {
                    System.out.println("hello " + userName);
                    flag = true;
                    break;
                } else {
                    flag = false;
                }
            }
            if (flag)
                break;
            else
                System.out.println("Username or password is wrong ❌");
        } while (true);
    }

    @Override
    public void menu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. To get your coach info\n" +
                "2. Display for all the Gym Equipment\n" +
                "3. Display my membership’s plan details\n" +
                "4. Display the in-body information at a specific date\n" +
                "5. Display how many kilos I need to reduce according to my inBody");

        System.out.println("Choose your choice");
        int choice = scanner.nextInt();


        switch (choice) {
            case 1:
                //displayAssignedCoachInfo();
                break;
            case 2:
                displayGymEquipment();
                break;
            case 3:
                //displayMemberShipDetails();
                break;
            case 4:
                //TODO make a method that searches inBody history list by date
                //int date = scanner.nextInt();
                //inBody.getInBodyDetails(date);
                break;
            case 5:
                chooseYourDreamBody();
                break;
            default:
                System.out.println("please enter a valid choice");
        }
    }

    public static Person signUp() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your Name");
        String name = scanner.nextLine();
        System.out.println("Enter your password:");
        String password = scanner.nextLine();
        System.out.println("Enter your Email");
        String email = scanner.nextLine();
        System.out.println("(Male / Female)");
        String gender = scanner.nextLine();
        System.out.println("Enter your address");
        String address = scanner.nextLine();
        System.out.println("Enter your Phone number");
        String phoneNum = scanner.nextLine();
        System.out.println("Enter your Age");
        int age = scanner.nextInt();

        System.out.println("Enter in-body date");
        System.out.println("Year:");
        int year = scanner.nextInt();
        System.out.println("Month:");
        int month = scanner.nextInt();
        System.out.println("Day:");
        int day = scanner.nextInt();
        System.out.println("Enter your desire");
        String desire = scanner.nextLine();
        System.out.println("Enter your height");
        Double height = scanner.nextDouble();
        System.out.println("Enter your weight");
        Double weight = scanner.nextDouble();
        System.out.println("Enter your bodyFatMass");
        Double bodyFatMass = scanner.nextDouble();
        System.out.println("Enter your bodyWater");
        Double bodyWater = scanner.nextDouble();
        InBody inBody = new InBody(LocalDate.of(year, month, day), desire, height, weight, bodyFatMass, bodyWater);

        System.out.println("Enter number of months you want to register");
        int numberOfMonthsRegistered = scanner.nextInt();
        System.out.println("Enter your number of days you want to register per week (3 / 6)");
        int numberOfDaysRegistered = scanner.nextInt();
        MemberShip memberShip = new MemberShip(numberOfMonthsRegistered, numberOfDaysRegistered);

        System.out.println("Enter start year");
        int startYear = scanner.nextInt();
        System.out.println("Enter start month");
        int startMonth = scanner.nextInt();
        System.out.println("Enter start day");
        int startDay = scanner.nextInt();

        System.out.println("Member account is created successfully✅");

        LocalDate startDate = LocalDate.of(startYear, startMonth, startDay);
        LocalDate endDate = startDate.plusMonths(numberOfMonthsRegistered);
        Subscription subscription = new Subscription(2, 5, memberShip, startDate, endDate);

        Person person = new Customer(name, password, gender, address, phoneNum, email, age, inBody, subscription);
        return person;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + getName() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", gender='" + getGender() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", age=" + getAge() +
                ", " + inBody +
                ", " + subscription +
                '}';
    }

    //TODO display the in body information at a specific date
}