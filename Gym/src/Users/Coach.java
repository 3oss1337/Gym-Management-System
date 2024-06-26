package Users;

import GymDetails.Equipment;
import GymDetails.Gym;
import Users.Customer.Customer;
import Users.Customer.InBody;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class Coach extends Person implements Serializable {

    public int id;
    private int workingHours;   // per Day can't be more than 10H
    public static int coachId = 500;
    private List<Customer> customers;
    private static final long serialVersionUID = 1L;

    public Coach() {
    }

    public Coach(String name, String password, String gender, String address, String phoneNumber, String email, int age, int workingHours) {
        super(name, password, gender, address, phoneNumber, email, age);
        this.workingHours = workingHours;
    }

    public Coach(String name) {
        super(name);
    }

    public static void incrementCoachId() {
        coachId++;
    }

    public List<Customer> getAllTrainees() {
        return Gym.listOfCustomers;
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


    public void displayMyCustomers(String CoachName) {
        for (Customer customer : Gym.listOfCustomers) {
            if (customer.subscription.getCoachName().equals(CoachName))
                customer.displayInfo();
        }
    }


    public void getTraineeDetailsByName(String customerName) { //Returns details of a certain customer with a coach

        boolean flag = false;
        for (Customer customer : Gym.listOfCustomers) {
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
        boolean found = false;
        System.out.println("The " + gender + " customers are : ");
        for (Customer customer : Gym.listOfCustomers) {
            if (customer.gender.equalsIgnoreCase(gender)) {
                found = true;
                customer.displayInfo();
            }
        }

        if (!found)
            System.out.println("No " + gender + " customers for you");
    }

    public void callInBodyHistory(String coachName) {
        for (Customer customer : Gym.listOfCustomers) {
            if (customer.getName().equals(coachName)) {
                System.out.println("Trainee's in-body history");
                System.out.println(customer.inBody);
            }
        }
    }

    @Override
    public void menu() {
        Coach coach = (Coach) login();
        Scanner scanner = new Scanner(System.in);

        boolean back = false;
        do {
            System.out.println("1. Show a list of my customers\n" +
                    "2. Get the in-body history of a specific customer\n" +
                    "3. Get all the details of a specific customer by his name\n" +
                    "4. Show a list of all my female/male customers\n" +
                    "5. Log out ");

            System.out.println("Choose your choice");
            int choice = scanner.nextInt();

            int goBack;
            switch (choice) {
                case 1:
                    displayMyCustomers(coach.getName());
                    break;
                case 2:
                    System.out.println("Enter user name:");
                    String userName = new Scanner(System.in).nextLine();
                    callInBodyHistory(userName);
                    break;
                case 3:
                    System.out.println("Enter trainee's name: ");
                    String traineeName = new Scanner(System.in).nextLine();
                    getTraineeDetailsByName(traineeName);
                    break;
                case 4:
                    System.out.println("Choose which gender to display male/female");
                    String gender = new Scanner(System.in).nextLine();
                    getTraineesByGender(gender);
                    break;
                case 5:
                    System.out.println("Good Bye " + coach.getName() + " 👋");
                    break;
                default:
                    System.out.println("please enter a valid choice");
            }


        } while (Gym.goBack());

    }

    @Override
    public Person login() {

        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your UserName:");
            String userName = scanner.nextLine();
            System.out.println("Enter your password:");
            String password = scanner.nextLine();
            boolean flag = false;
            for (Coach coach : Gym.listOfCoaches) {
                if (coach.getName().equals(userName) && coach.getPassword().equals(password)) {
                    System.out.println("hello " + userName);
                    flag = true;
                    return coach;
                } else {
                    flag = false;
                }
            }
            if (flag)
                break;
            else
                System.out.println("Username or password is wrong ❌");
        } while (true);
        return null;
    }

    @Override
    public void displayInfo() {
        System.out.println("Name:" + this.name);
        System.out.println("Phone number:" + this.phoneNumber);
        System.out.println("Gender:" + this.gender);
        System.out.println("Mail:" + this.email+ '\n');

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
        int wHours;
        do {
            System.out.println("Enter working hours");
            wHours = scanner.nextInt();
        } while (wHours > 10);
        Person person = new Coach(name, password, gender, address, phoneNum, email, age, wHours);

        System.out.println("Coach created successfully✅");
        return person;
    }

    public String toString() {
        return "Coach{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", workingHours=" + workingHours +
                '}';
    }
}

class CoachSortByNumOfMembers implements Comparator<Coach> {
    @Override
    public int compare(Coach coach1, Coach coach2) {
        // Compare coaches based on the number of customers they have
        int numOfMembers1 = coach1.getAllTrainees().size();
        int numOfMembers2 = coach2.getAllTrainees().size();

        // Descending order (largest number of members first)
        return Integer.compare(numOfMembers2, numOfMembers1);
    }

    public static void sortCoachesByNumOfMembers(List<Coach> coaches) {
        Collections.sort(coaches, new CoachSortByNumOfMembers());

        System.out.println("Coaches sorted by the number of members:");
        for (Coach coach : coaches) {
            System.out.println("Coach: " + coach.getName() + ", Number of Customers: " + coach.getAllTrainees().size());
        }
    }
}