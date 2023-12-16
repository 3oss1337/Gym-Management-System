package Users;

import GymDetails.Gym;
import Users.Customer.Customer;
import Users.Customer.InBody;
import Users.Customer.MemberShip;
import Users.Customer.Subscription;

import java.time.LocalDate;
import java.util.Scanner;

public class SystemUser extends Person {
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

    }

    @Override
    public void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your UserName:");
        String userName = scanner.nextLine();
        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        /*do {
            boolean flag = false;
            for (int i = 2; i < Gym.listOfSystemUsers.size(); i += 2) {
                if (Gym.listOfSystemUsers.contains(userName) && Gym.listOfSystemUsers.get(i + 1).equals(password)) {
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
        } while (true);*/
    }

    @Override
    public void menu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Add user \n2. edit user \n3. delete user \n" +
                "4. Get subscription history of a customer\n");

        System.out.println("Choose your choice");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                Person person = Customer.signUp();
                SystemUser.addCustomer((Customer) person);
                break;
            case 2:
                //SystemUser.editCustomer();
                break;
            case 3:
                //SystemUser.deleteCustomer();
                break;
            case 4:
                //(Same FN of the admin)
                //TODO call display Subscription history FN a Specific customer
                break;
            default:
                System.out.println("please enter a valid choice");
        }
    }

    public static void addCustomer(Customer customer) {
        Gym.listOfCustomers.add(customer);
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

        System.out.println("System user added successfully✅");

        Person person = new SystemUser(name, password, email, gender, address, phoneNum, age, wHours);
        return person;
    }
}
