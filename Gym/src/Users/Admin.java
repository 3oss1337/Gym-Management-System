package Users;

import GymDetails.Equipment;
import GymDetails.Gym;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static Users.Coach.signUp;

public class Admin extends Person {

    public Admin() {

    }

    @Override
    public void displayInfo() {

    }

    @Override
    public void login() {
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your UserName:");
            String userName = scanner.nextLine();
            System.out.println("Enter your password:");
            String password = scanner.nextLine();

            if (userName.equals("admin") && password.equals("admin"))
                break;
            else
                System.out.println("Username or password is wrong ❌");
        } while (true);
    }

    @Override
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello Boss");

        System.out.println("1. Add \n2. edit \n3. delete\n" +
                "4. Get subscription history of a customer\n" +
                "5. Display all the customers that subscribed to the gym in a given month/day\n" +
                "6. Display all the customers of a specific coach\n" +
                "7. Display the GYM income in a given month\n" +
                "8. Display the coaches sorted in terms of the most assigned number of customers to the coaches");

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
                //TODO edit case 2,3
                switch (typesAdminCanEdit()) {
                    case 1:
                        //Admin.edit("Coach.txt");
                        break;
                    case 2:
                        //    Admin.edit("Receptionist.txt");
                        break;
                    case 3:
                        //Admin.edit("Equipment.txt");
                        break;
                }
                break;
            case 3:
                switch (typesAdminCanEdit()) {
                    case 1:
                        //Admin.delete("Coach.txt");
                        break;
                    case 2:
                        //Admin.delete("Receptionist.txt");
                        break;
                    case 3:
                        //Admin.delete("Equipment.txt");
                        break;
                }
                break;
            case 4:
                //TODO call display Subscription history FN a Specific customer
                break;
            case 5:
               /* if (GYM.listOfCoaches != null) {
                    System.out.println("Deserialized People:");
                    for (Coach coach : GYM.listOfCoaches) {
                        System.out.println(coach);
                    }
                }*/
                break;
            case 6:
                //TODO call FN that display all the users for a specific coach
                break;
            case 7:
                //TODO call FN that display gym income in a specific month
                break;
            case 8:
                //TODO call FN that display coaches sorted by most member with
                break;
            default:
                System.out.println("please enter a valid choice");
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

    public static void addSystemUser(SystemUser systemUser) {
        Gym.listOfSystemUsers.add(systemUser);
    }

    public static void addEquipment(Equipment equipment) {
        Gym.listOfEquipments.add(equipment);
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




