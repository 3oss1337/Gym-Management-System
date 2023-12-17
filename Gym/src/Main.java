import Users.*;
import GymDetails.*;
import Users.Customer.Customer;
import Users.Customer.InBody;
import Users.Customer.MemberShip;
import Users.Customer.Subscription;

import java.time.LocalDate;
import java.util.*;
import java.io.*;
import java.lang.*;


public class Main {
    public static void main(String[] args) {

        /*if(gym.listOfCoaches ==null)
        {
            Coach coach = new Coach("Ahmed","roveto","Male","123square","01009079081","ae34@gmail.com",20,7);
            gym.listOfCoaches.add(coach);

        }*/
        ArrayList<Coach> coaches = new ArrayList<>();
        for(Coach coach : coaches)
        {
            Coach loadedCoach = coach;
            Gym.listOfCoaches.add(loadedCoach);
        }
        char c;
        do {
            Gym.mainMenu();

            Scanner scanner = new Scanner(System.in);
            System.out.println("Press y to continue n to exit");
            c = scanner.nextLine().charAt(0);

        } while (c != 'N' && c != 'n');

        coaches.clear();
        coaches.addAll(Gym.listOfCoaches);
        Gym.saveObject(coaches,"Coach.txt");

       coaches = (ArrayList<Coach>) Gym.loadObject("Coach.txt");


        if(coaches !=null)
        {
            for (Coach coach1 : coaches) {
                System.out.println(coach1);
            }
        }



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