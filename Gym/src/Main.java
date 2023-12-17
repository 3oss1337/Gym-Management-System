import Users.*;
import GymDetails.*;
import Users.Customer.Customer;

import java.util.*;
import java.lang.*;


public class Main {
    public static void main(String[] args) {
        Gym.listOfCoaches.addAll((ArrayList<Coach>) Gym.loadFeomFile("Coach.txt"));
        Gym.listOfCustomers.addAll((ArrayList<Customer>) Gym.loadFeomFile("Customer.txt"));
        Gym.listOfSystemUsers.addAll((ArrayList<SystemUser>) Gym.loadFeomFile("Receptionist.txt"));
        Gym.listOfEquipments.addAll((ArrayList<Equipment>) Gym.loadFeomFile("Equipment.txt"));

        Gym.displayCoaches(Gym.listOfCoaches);
        Gym.displayCustomers(Gym.listOfCustomers);

        Gym.displaySystemUsers(Gym.listOfSystemUsers);
        Gym.displayEquipments(Gym.listOfEquipments);


        char c;
        do {
            Gym.mainMenu();

            Scanner scanner = new Scanner(System.in);
            System.out.println("Press y to continue n to exit");
            c = scanner.nextLine().charAt(0);

        } while (c != 'N' && c != 'n');

        Gym.saveToFile(Gym.listOfCoaches, "Coach.txt");
        Gym.saveToFile(Gym.listOfCustomers, "Customer.txt");
        Gym.saveToFile(Gym.listOfSystemUsers, "Receptionist.txt");
        Gym.saveToFile(Gym.listOfEquipments, "Equipment.txt");

/*
        MemberShip m1 = new MemberShip(3,6);
        Subscription s1 = new Subscription(1, 501,m1);
        InBody inbody = new InBody("GAIN_MUSCLE",1.8,100,33,57, LocalDate.now());

        Customer c2 = new Customer("Ahmed", "Tallo", "123", "123", "123", "123", 12,s1);
*/
/*Coach coach = new Coach("salah","sss","M","address","01111111","adsa@gmail.com",30);
        inbody.knowNeeded(c2);
        c2.addToInBodyHistory(inbody);
        coach.callInBodyHistory(c2);
*/
/*        m1.calculateTotalPrice(3, m1.calcMonthPrice(6));
        Gym.addSubscription(s1);
        c2.displayMemberShipDetails();
        System.out.println(inbody.canPerformInBody(c2));
        c2.performInBody(inbody);
        System.out.println(inbody.canPerformInBody(c2));*/


    }
}