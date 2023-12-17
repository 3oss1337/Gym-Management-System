package Users.Customer;

import java.io.Serializable;

public class MemberShip implements Serializable {
    private int numberOfMonthsRegistered;
    private int numberOfDaysRegistered;
    private double price = 0;

    public MemberShip(int numberOfMonthsRegistered, int numberOfDaysRegistered) {
        this.numberOfMonthsRegistered = numberOfMonthsRegistered;
        this.numberOfDaysRegistered = numberOfDaysRegistered;
    }

    public int getNumberOfMonthsRegistered() {
        return numberOfMonthsRegistered;
    }

    public void setNumberOfMonthsRegistered(int numberOfMonthsRegistered) {
        this.numberOfMonthsRegistered = numberOfMonthsRegistered;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public int getNumberOfDaysRegistered() {
        return numberOfDaysRegistered;
    }

    public void setNumberOfDaysRegistered(int numberOfMonthsRegistered) {
        this.numberOfDaysRegistered = numberOfMonthsRegistered;
    }

    public double calcMonthPrice(int numberOfDaysRegistered) {

        if (getNumberOfDaysRegistered() == 3) {
            setPrice(200);
        } else if (getNumberOfDaysRegistered() == 6) {
            setPrice(400);
        }
        return getPrice();
    }

    public double calculateTotalPrice(int numberOfMonthsRegistered, double priceOfMonth) {

        if (getNumberOfMonthsRegistered() == 3) {
            setPrice(getPrice() * numberOfMonthsRegistered - (0.25 * numberOfMonthsRegistered * getPrice()));
            return getPrice();
        } else if (getNumberOfMonthsRegistered() == 6) {
            setPrice(getPrice() * numberOfMonthsRegistered - (0.3329 * numberOfMonthsRegistered * getPrice()));
            return getPrice();
        } else if (getNumberOfMonthsRegistered() == 12) {
            setPrice(getPrice() * numberOfMonthsRegistered - (0.45 * numberOfMonthsRegistered * getPrice()));
            return getPrice();
        } else {
            return getPrice();
        }
    }

    public void displayPlans() {

    }

    public void display() {
        System.out.println("Your membership's number of days is : " + getNumberOfDaysRegistered());
        System.out.println("Your membership's number of plans is : " + getNumberOfMonthsRegistered());
        System.out.println((int) (getPrice() - getPrice() % 100));
    }

    public String toString() {
        return "Ur Member Ship Plan {" + "Number Of Days '" + numberOfDaysRegistered + '\'' + ",Number Of Months '" + numberOfMonthsRegistered + '\'' + ", Price '" + price + '\'' + '}';
    }
}