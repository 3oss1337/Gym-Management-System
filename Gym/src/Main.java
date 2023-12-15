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




        MemberShip m1 = new MemberShip(3,6);
        Subscription s1 = new Subscription(1, 501,m1);
        InBody inbody = new InBody(1.8,100,33,57, LocalDate.now());


        Customer c2 = new Customer("Ahmed", "Tallo", "123", "123", "123", "123", 12,s1);

        m1.calculateTotalPrice(3, m1.calcMonthPrice(6));
        Gym.addSubscription(s1);
        c2.displayMemberShipDetails();
        System.out.println(inbody.canPerformInBody(c2));
        c2.performInBody(inbody);
        System.out.println(inbody.canPerformInBody(c2));


    }
}