package Users;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Admin extends Person {

    public Admin(){

    }
    @Override
    public void displayInfo() {

    }

    @Override
    public void login() {

    }

    @Override
    public void mainMenu() {

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




