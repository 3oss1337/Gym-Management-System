package Users;

import GymDetails.Gym;
import Users.Customer.Customer;
import Users.Customer.MemberShip;
import Users.Customer.Subscription;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;

import static GymDetails.Gym.listOfCoaches;

public class SystemUser extends Person implements Serializable {
    private static final long serialVersionUID = -2413217214226144664L;
    private int workingHours;
    private int id;

    public SystemUser() {
    }

    public SystemUser(String name, String password, String gender, String address, String phoneNumber, String email, int age, int workingHours) {
        super(name, password, gender, address, phoneNumber, email, age);
        this.workingHours = workingHours;
    }

    @Override
    public void displayInfo() {
        System.out.println("Name:" + this.name);
        System.out.println("Phone number:" + this.phoneNumber);
        System.out.println("Gender:" + this.gender);
        System.out.println("Mail:" + this.email);
        System.out.println("Age:" + this.age);
        System.out.println("Working hours:" + this.workingHours);

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
            for (SystemUser systemUser : Gym.listOfSystemUsers) {
                if (systemUser.getName().equals(userName) && systemUser.getPassword().equals(password)) {
                    System.out.println("hello " + userName);
                    flag = true;
                    return systemUser;
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
        int choice;

        do {
            Scanner scanner = new Scanner(System.in);

            System.out.println("1. Add user \n2. edit user \n3. delete user \n" +
                    "4. Get subscription history of a customer\n" +
                    "5. Renew a customer subscription\n" +
                    "6. Log out");

            System.out.println("Choose your choice");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Person person = Customer.signUp();
                    SystemUser.addCustomer((Customer) person);
                    break;
                case 2:
                    SystemUser.editCustomer();
                    break;
                case 3:
                    SystemUser.deleteCustomer();
                    break;
                case 4:
                    //(Same FN of the admin)
                    //TODO call display Subscription history FN a Specific customer
                    break;
                case 5:
                    //SystemUser.renew();
                case 6:
                    System.out.println("Good Bye 👋");
                    break;
                default:
                    System.out.println("please enter a valid choice");
            }
        }while (choice != 6);
    }

    public static void addCustomer(Customer customer) {
        Gym.listOfCustomers.add(customer);
    }

    public static void editCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter mobile number for the member you want to edit his info: ");
        String searchTerm = scanner.nextLine();

        boolean found = false;

        for (Customer customer : Gym.listOfCustomers) {
            if (customer.getPhoneNumber().equals(searchTerm)) {

                found = true;
                customer.displayInfo();
                System.out.println("what value you need to edit\n" +
                        "1.mobile number\t" +
                        "2.password\t" +
                        "3.address\t" +
                        "4.renew");

                int choice = scanner.nextInt();
                String newValue = "";

                Scanner scanner1 = new Scanner(System.in);

                if (choice != 4) {
                    System.out.println("Enter the new value");
                    newValue = scanner1.nextLine();
                }

                switch (choice) {
                    case 1:
                        customer.setPhoneNumber(newValue);
                        break;
                    case 2:
                        customer.setPassword(newValue);
                        break;
                    case 3:
                        customer.setAddress(newValue);
                        break;
                    case 4:
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

                        boolean correctCoach;
                        String coachName;

                        do {
                            correctCoach = false;
                            System.out.println("Enter coach name");
                            coachName = new Scanner(System.in).nextLine();

                            for (Coach coach : listOfCoaches) {
                                if (coachName.equals(coach.getName()))
                                    correctCoach = true;
                            }
                            if (!correctCoach)
                                System.out.println("there is no coach named " + coachName + ". please try again");

                        }while (!correctCoach);


                        LocalDate startDate = LocalDate.of(startYear, startMonth, startDay);
                        LocalDate endDate = startDate.plusMonths(numberOfMonthsRegistered);
                        Subscription subscription = new Subscription(2, coachName, memberShip, startDate, endDate);

                        Gym.listOfSubscriptions.add(subscription);

                        customer.subscription = subscription;

                }
                System.out.println("User edited succesfully✅");
            }
            if (found)
                break;
        }
        if (!found)
            System.out.println("There no user with this number");
    }

    public static void deleteCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Search by: " +
                "1. name\t" +
                "2. phone number");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter user name: ");
                String name = scanner.nextLine();
                for (Customer customer : Gym.listOfCustomers) {
                    if (customer.getName().equals(name)) {
                        Gym.listOfCustomers.remove(customer);
                        break;
                    }
                }
                break;
            case 2:
                System.out.print("Enter phone number: ");
                String phoneNum = scanner.nextLine();
                for (Customer customer : Gym.listOfCustomers) {
                    if (customer.getName().equals(phoneNum)) {
                        Gym.listOfCustomers.remove(customer);
                    }
                }
                break;
        }

        System.out.println("User deleted succesfully✅");
    }

    /*public static void renew() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter mobile number for the member you want to edit his info: ");
        String searchTerm = scanner.nextLine();

        boolean found = false;
        for (Customer customer : Gym.listOfCustomers) {
            if (customer.getPhoneNumber().equals(searchTerm)) {
                found = true;
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Enter number of months you want to register");
                int numberOfMonthsRegistered = scanner1.nextInt();
                System.out.println("Enter your number of days you want to register per week (3 / 6)");
                int numberOfDaysRegistered = scanner1.nextInt();
                MemberShip memberShip = new MemberShip(numberOfMonthsRegistered, numberOfDaysRegistered);

                System.out.println("Enter start year");
                int startYear = scanner1.nextInt();
                System.out.println("Enter start month");
                int startMonth = scanner1.nextInt();
                System.out.println("Enter start day");
                int startDay = scanner1.nextInt();

                LocalDate startDate = LocalDate.of(startYear, startMonth, startDay);
                LocalDate endDate = startDate.plusMonths(numberOfMonthsRegistered);
                Subscription subscription = new Subscription(customer.getId(), "Ahmed", memberShip, startDate, endDate);

                customer.setSubscription(subscription);
            }
        }
    }*/

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

        System.out.println("System user added successfully✅");

        Person person = new SystemUser(name, password, gender, address, phoneNum, email, age, wHours);
        return person;
    }

    public String toString() {
        return "System User{" +
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
