package Users.Customer;

import GymDetails.Equipment;
import Users.Coach;
import Users.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static GymDetails.Gym.listOfCoaches;
import static GymDetails.Gym.sportEquipment;

public class Customer extends Person {
    private int id;
    public InBody inBody;
    public static List<Subscription> subscriptions;

    public static Subscription subscription;
    private List<InBody> inBodies;
    LocalDate lastInBodyDate;
    public static int customerId = 0;



    public static void incrementCustomerId() {
        customerId++;
    }
    public Customer(String name, String password, String gender, String address, String phoneNumber, String email, int age,Subscription sub) {
        super(name,password, gender, address,phoneNumber,email, age);
        incrementCustomerId();
        this.id=customerId;
        subscription=sub;
        subscriptions = new ArrayList<>();
        this.inBodies = new ArrayList<>();




    }

    public Customer(String name) {
        super(name);
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

    public LocalDate getLastInBodyDate() {
        return lastInBodyDate;
    }
    @Override
    public void displayInfo() {
        System.out.println("Name:"+ this.name);
        System.out.println("Phone number:"+ this.phoneNumber);
        System.out.println("Gender:"+ this.gender);
        System.out.println("Mail:"+ this.email);
        System.out.println("ID:"+ this.id);
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

    public List<InBody> getInBodies() {
        return inBodies;
    }

    public void setInBodies(List<InBody> inBodies) {
        this.inBodies = inBodies;
    }





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void displayAssignedCoachInfo(){
        for(Coach coach : listOfCoaches){
            if(Customer.subscription.getCoachId()==coach.id)
            {
                System.out.println(coach.id);

            }
        }


    }

    public void displayGymEquipment(){

        for(Equipment equipment : sportEquipment)
        {
            equipment.displayDetails();

        }
    }

    public void displayMemberShipDetails()
    {

        Customer.subscription.getMembership().display();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", lastInBodyDate=" + lastInBodyDate +
                '}';
    }

    //TODO display the inbody information at a specific date
    //TODO Display for the user how many kilos need to be reduced

}