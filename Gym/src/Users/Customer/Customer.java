package Users.Customer;

import GymDetails.Gym;
import Users.Coach;
import Users.Person;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static GymDetails.Gym.listOfCoaches;

public class Customer extends Person implements Serializable {
    private int id;
    public InBody inBody;

    public static List<Subscription> subscriptionsList;
    public Subscription subscription;
    public List<InBody> inBodies;
    LocalDate lastInBodyDate;
    public static int customerId = 0;
    private static final long serialVersionUID = 9030088271766756025L;

    public static void incrementCustomerId() {
        customerId++;
    }

    public Customer() {
    }

    public Customer(String name, String password, String gender, String address, String phoneNumber, String email, int age, InBody inBody, Subscription subscription) {
        super(name, password, gender, address, phoneNumber, email, age);
        this.inBody = inBody;
        this.subscription = subscription;
        this.subscriptionsList = new ArrayList<>();
        this.inBodies = new ArrayList<>();
        this.inBodies.add(inBody);
    }

    public List<InBody> getInBodies() {
        return inBodies;
    }

    public void setInBodies(List<InBody> inBodies) {
        this.inBodies = inBodies;
    }

    public static List<Subscription> getSubscriptionsList() {
        return subscriptionsList;
    }

    public static void setSubscriptionsList(List<Subscription> subscriptionsList) {
        Customer.subscriptionsList = subscriptionsList;
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

    public Subscription getSubscription() {
        return subscription;
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

    public static void displayAssignedCoachForCustomer(String customerName) {
        boolean found = false;
        for (Customer customer : Gym.listOfCustomers) {
            if (customer.getName().equalsIgnoreCase(customerName)) {
                for (Coach coach : Gym.listOfCoaches) {
                    if (customer.getSubscription().getCoachName().equals(coach.getName())) {
                        System.out.println("Assigned Coach for " + customer.getName() + ":");
                        coach.displayInfo();
                        found = true;
                        break;
                    }
                }
                break;
            }
        }
        if (!found) {
            System.out.println("No coach found");
        }
    }

    public void displayMemberShipDetails(Customer customer) {
        customer.subscription.getMembership().display();
    }
    @Override
    public void displayInfo() {
        System.out.println("Name:" + this.name);
        System.out.println("Phone number:" + this.phoneNumber);
        System.out.println("Gender:" + this.gender);
        System.out.println("Mail:" + this.email);
        System.out.println("ID:" + this.id + '\n');
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

            for (Customer customer : Gym.listOfCustomers) {
                if (customer.getName().equalsIgnoreCase(userName) && customer.getPassword().equals(password)) {
                    System.out.println("hello " + userName);
                    flag = true;
                    return customer;
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
    public void menu() {

        Customer customer = (Customer) login();
        boolean back = false;

        do{
            Scanner scanner = new Scanner(System.in);

            System.out.println("1. To get your coach info\n" +
                    "2. Display for all the Gym Equipment\n" +
                    "3. Display my membership’s plan details\n" +
                    "4. Display the in-body information at a specific date\n" +
                    "5. Add new in-body\n"+
                    "6. Display how many kilos I need to reduce according to my inBody\n" +
                    "7. Log out");

            System.out.println("Choose your choice");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayAssignedCoachForCustomer(customer.getName());
                    back = Gym.goBack();
                    break;
                case 2:
                    Gym.displayEquipments();
                    break;
                case 3:
                    customer.subscription.getMembership().display();
                    back = Gym.goBack();
                    break;
                case 4:
                    System.out.println("Enter in-body date");
                    System.out.println("Year:");
                    int year = scanner.nextInt();
                    System.out.println("Month:");
                    int month = scanner.nextInt();
                    System.out.println("Day:");
                    int day = scanner.nextInt();

                    customer.inBody.getInBodyDetails(LocalDate.of(year, month, day), customer);
                    back = Gym.goBack();
                    break;
                case 5:
                    System.out.println("Enter in-body date");
                    System.out.println("Year:");
                    year = scanner.nextInt();
                    System.out.println("Month:");
                    month = scanner.nextInt();
                    System.out.println("Day:");
                    day = scanner.nextInt();
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
                    InBody newInBody = new InBody(LocalDate.of(year, month, day), desire, height, weight, bodyFatMass, bodyWater);
                    this.inBodies.add(newInBody);

                    this.inBody = newInBody;
                    break;
                case 6:
                    customer.inBody.knowNeeded(customer);
                    back = Gym.goBack();
                    break;
                case 7:
                    System.out.println("Good Bye " + customer.getName() + " 👋");
                    break;
                default:
                    System.out.println("please enter a valid choice");
            }
        }while(back);

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

        Gym.displayCoaches(listOfCoaches);

        System.out.println("Enter coach name");
        String coachName = new Scanner(System.in).nextLine();

        System.out.println("Member account is created successfully✅");

        LocalDate startDate = LocalDate.of(startYear, startMonth, startDay);
        LocalDate endDate = startDate.plusMonths(numberOfMonthsRegistered);
        Subscription subscription = new Subscription(2, coachName, memberShip, startDate, endDate);
        Gym.listOfSubscriptions.add(subscription);

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

    //TODO add new inbody
}