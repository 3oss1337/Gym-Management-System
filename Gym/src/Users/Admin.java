package Users;

import GymDetails.Equipment;
import GymDetails.Gym;
import Users.Customer.Customer;

import java.io.Serializable;
import java.lang.management.MonitorInfo;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

import static Users.Coach.signUp;

public class Admin extends Person implements Serializable {

    public Admin() {

    }

    @Override
    public void displayInfo() {
    }

    @Override
    public Person login() {
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your UserName:");
            String userName = scanner.nextLine();
            System.out.println("Enter your password:");
            String password = scanner.nextLine();

            if (userName.equals("admin") && password.equals("admin"))
                return null;
            else
                System.out.println("Username or password is wrong ❌");
        } while (true);
    }

    @Override
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello Boss");

        System.out.println("1. Add \n2. Search \n" +
                "3. Display all the customers that subscribed to the gym in a given month/day\n" +
                "5. Display all the customers of a specific coach\n" +
                ". Display the coaches sorted in terms of the most assigned number of customers to the coaches");

        System.out.println("Choose your choice");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                Person person;
                switch (typesAdminCanEdit()) {
                    case 1:
                        person = Coach.signUp();
                        Admin.addCoach((Coach) person);
                        break;
                    case 2:
                        person = SystemUser.signUp();
                        Admin.addSystemUser((SystemUser) person);
                        break;
                    case 3:
                        Admin.addEquipment(Equipment.addEquipmentInfo());
                        break;
                    default:
                        System.out.println("please enter a valid choice");
                }
                break;
            case 2:
                switch (typesAdminCanEdit()) {
                    case 1:
                        Admin.editDeleteCoach();
                        break;
                    case 2:
                        Admin.editDeleteSystemUser();
                        break;
                    case 3:
                        Admin.editEquipment();
                        break;
                }
                break;
            case 3:
                System.out.println("Enter month: ");
                int number = new Scanner(System.in).nextInt();
                Month month =LocalDate.of(2023, number, 16).getMonth() ;
                for (Customer customer : Gym.listOfCustomers) {
                    if (customer.getSubscription().getStartDate().getMonth().compareTo(month) == 0) {
                        customer.displayInfo();
                    }
                }
                break;
            case 5:
                System.out.println("Enter coach name: ");
                String coachName = new Scanner(System.in).nextLine();
                displayAllUsersForASpecific(coachName);
                break;
            case 6:
                Users.CoachSortByNumOfMembers.sortCoachesByNumOfMembers(Gym.listOfCoaches);
                break;
            default:
                System.out.println("please enter a valid choice");
        }
    }

    private void displayAllUsersForASpecific(String targetCoach) {
        for (Customer customer : Gym.listOfCustomers) {
            if (customer.getSubscription().getCoachName().equals(targetCoach)) {
                customer.displayInfo();
            }
        }
    }

    private static int typesAdminCanEdit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Coaches\n" +
                "2. System users\n" +
                "3. Equipments");

        System.out.println("Choose your choice");
        int choice = scanner.nextInt();

        return choice;
    }

    public static void addCoach(Coach coach) {
        Gym.listOfCoaches.add(coach);
    }
    public static void editDeleteCoach (){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Search by:\n" +
                "1. name \t" +
                "2. phone number");
        int choice = scanner.nextInt();

        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter it's value: ");
        String searchTerm = scanner1.nextLine();
        boolean found = false;

        switch (choice){
            case 1:
                for (Coach coach: Gym.listOfCoaches){
                    if (coach.getName().equals(searchTerm)){
                        found = true;

                        coach.displayInfo();
                        System.out.println("what do you want to do:\n" +
                                "1. edit\t" +
                                "2. delete");
                        choice = scanner.nextInt();

                        if (choice == 1){
                            System.out.println("what value you need to edit\n" +
                                    "1.mobile number\t" +
                                    "2.password\t" +
                                    "3.address");

                            choice = scanner.nextInt();

                            System.out.println("Enter the new value");
                            String newValue = scanner1.nextLine();

                            switch (choice){
                                case 1:
                                    coach.setPhoneNumber(newValue);
                                    break;
                                case 2:
                                    coach.setPassword(newValue);
                                    break;
                                case 3:
                                    coach.setAddress(newValue);
                                    break;
                            }
                        } else if (choice == 2) {
                            Gym.listOfCoaches.remove(coach);
                        }
                    }
                    if (found)
                        break;
                }
                break;
            case 2:
                for (Coach coach: Gym.listOfCoaches){
                    if (coach.phoneNumber.equals(searchTerm)){
                        found = true;

                        coach.displayInfo();
                        System.out.println("what do you want to do" +
                                "1.edit\t" +
                                "2.delete");
                        choice = scanner.nextInt();

                        if (choice == 1){
                            System.out.println("what value you need to edit\n" +
                                    "1.mobile number\t" +
                                    "2.password\t" +
                                    "3.address");

                            choice = scanner.nextInt();

                            System.out.println("Enter the new value");
                            String newValue = scanner1.nextLine();

                            switch (choice){
                                case 1:
                                    coach.setPhoneNumber(newValue);
                                    break;
                                case 2:
                                    coach.setPassword(newValue);
                                    break;
                                case 3:
                                    coach.setAddress(newValue);
                                    break;
                            }
                        } else if (choice == 2) {
                            Gym.listOfCoaches.remove(coach);
                        }
                    }
                    if (found)
                        break;
                }
                break;
        }
        if (!found)
            System.out.println("There no coach with this number");
    }

    public static void addSystemUser(SystemUser systemUser) {
        Gym.listOfSystemUsers.add(systemUser);
    }
    public static void editDeleteSystemUser (){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Search by:\n" +
                "1. name \t" +
                "2. phone number");
        int choice = scanner.nextInt();

        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter it's value: ");
        String searchTerm = scanner1.nextLine();
        boolean found = false;

        switch (choice){
            case 1:
                for (SystemUser systemUser: Gym.listOfSystemUsers){
                    if (systemUser.getName().equals(searchTerm)){
                        found = true;

                        systemUser.displayInfo();
                        System.out.println("what do you want to do: \n" +
                                "1. edit\t" +
                                "2. delete");
                        int editOrDelete =  new Scanner(System.in).nextInt();

                        if (editOrDelete == 1){
                            System.out.println("what value you need to edit\n" +
                                    "1.mobile number\t" +
                                    "2.password\t" +
                                    "3.address");

                            choice = scanner.nextInt();

                            System.out.println("Enter the new value");
                            String newValue = new Scanner(System.in).nextLine();

                            switch (choice){
                                case 1:
                                    systemUser.setPhoneNumber(newValue);
                                    break;
                                case 2:
                                    systemUser.setPassword(newValue);
                                    break;
                                case 3:
                                    systemUser.setAddress(newValue);
                                    break;
                            }
                            System.out.println("System user edited succesfully✅" );
                        }
                        else if (editOrDelete == 2){
                            Gym.listOfSystemUsers.remove(systemUser);
                            System.out.println("System user deleted succesfully✅");
                        }
                    }
                    if (found)
                        break;
                }
                break;
            case 2:
                for (SystemUser systemUser: Gym.listOfSystemUsers){
                    if (systemUser.phoneNumber.equals(searchTerm)){
                        found = true;

                        systemUser.displayInfo();
                        System.out.println("what do you want to do" +
                                "1.edit\t" +
                                "2.delete");
                        choice = scanner.nextInt();

                        if (choice == 1){
                            System.out.println("what value you need to edit\n" +
                                    "1.mobile number\t" +
                                    "2.password\t" +
                                    "3.address");

                            choice = scanner.nextInt();

                            System.out.println("Enter the new value");
                            String newValue = scanner1.nextLine();

                            switch (choice){
                                case 1:
                                    systemUser.setPhoneNumber(newValue);
                                    break;
                                case 2:
                                    systemUser.setPassword(newValue);
                                    break;
                                case 3:
                                    systemUser.setAddress(newValue);
                                    break;
                            }
                            System.out.println("System user deleted succesfully✅");
                        } else if (choice == 2) {
                            Gym.listOfSystemUsers.remove(systemUser);
                            System.out.println("System user deleted succesfully✅");
                        }
                    }
                    if (found)
                        break;
                }
                break;
        }
        if (!found)
            System.out.println("There no user with this number");
    }
    public static void addEquipment(Equipment equipment) {
        Gym.listOfEquipments.add(equipment);
    }
    public static void editEquipment (){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter equipment code you want to edit its info: ");
        String searchTerm = scanner.nextLine();

        boolean found = false;

        for (Equipment equipment: Gym.listOfEquipments){
            if (equipment.equipmentCode.equals(searchTerm)) {
                found = true;

                equipment.displayInfo();
                equipment.displayInfo();
                System.out.println("what do you want to do: \n" +
                        "1. edit\t" +
                        "2. delete");
                int editOrDelete =  new Scanner(System.in).nextInt();

                if (editOrDelete == 1) {
                    System.out.println("what value you need to edit\n" +
                            "1.Equipment code\t" +
                            "2.quantity");

                    int choice = scanner.nextInt();

                    System.out.println("Enter the new value");
                    Scanner scanner1 = new Scanner(System.in);

                    switch (choice) {
                        case 1:
                            String newValue = scanner1.nextLine();
                            equipment.setEquipmentCode(newValue);
                            break;
                        case 2:
                            int newVal = scanner1.nextInt();
                            equipment.setQuantity(newVal);
                            break;
                    }
                    System.out.println("Equipment deleted succesfully✅" );
                }else if(editOrDelete == 2){
                    Gym.listOfEquipments.remove(equipment);
                    System.out.println("Equipment deleted succesfully✅" );
                }
            }
            if (found)
                break;
        }
        if (!found)
            System.out.println("There no equipment with this code");
    }
    public static class CoachSortByNumOfMembers implements Comparator<Coach> {
        @Override
        public int compare(Coach coach1, Coach coach2) {
            // Compare coaches based on the number of customers they have
            int numOfMembers1 = coach1.getAllTrainees().size();
            int numOfMembers2 = coach2.getAllTrainees().size();

            // Descending order (largest number of members first)
            return Integer.compare(numOfMembers2, numOfMembers1);
        }
    }

    public static void sortCoachesByNumOfMembers(List<Coach> coaches) {
        Collections.sort(coaches, new CoachSortByNumOfMembers());
        System.out.println("Coaches sorted by the number of members:");
        for (Coach coach : coaches) {
            System.out.println("Coach: " + coach.getName() + ", Number of Customers: " + coach.getAllTrainees().size());
        }

    }
}




