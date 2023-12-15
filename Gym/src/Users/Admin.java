package Users;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Admin extends Person {

    public Admin(){

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
        }while (true);
    }

    @Override
    public void mainMenu() {

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


    @Override
    public void register() {

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




