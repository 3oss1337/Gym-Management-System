package Users.Customer;

import java.time.LocalDate;
import java.util.Date;

public class InBody {
    protected LocalDate dateOfInBody;
    protected String desire;

    protected enum kDesires {LOSS_WEIGHT, GAIN_MUSCLE, NORMAL_BODY}

    ;
    protected double height;            //in CM
    protected double weight;            //in kg
    protected double bodyFatMass;       //in kg
    protected double bodyWater;         //in kg
    protected double fatNeeded;

    public double getFatNeeded() {
        return fatNeeded;
    }

    public double getCarbNeeded() {
        return carbNeeded;
    }

    public double getProteinNeeded() {
        return proteinNeeded;
    }

    protected double carbNeeded;
    protected double proteinNeeded;
    public InBody(LocalDate dateOfInBody, String desire,double height, double weight, double bodyFatMass, double bodyWater) {
        this.desire=desire;
        this.dateOfInBody = dateOfInBody;
        this.height = height;
        this.weight = weight;
        this.bodyFatMass = bodyFatMass;
        this.bodyWater = bodyWater;
    }

    public LocalDate getDateOfInBody() {
        return dateOfInBody;
    }

    public void setDateOfInBody(LocalDate dateOfInBody) {
        this.dateOfInBody = dateOfInBody;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getBodyFatMass() {
        return bodyFatMass;
    }

    public void setBodyFatMass(double bodyFatMass) {
        this.bodyFatMass = bodyFatMass;
    }

    public double getBodyWater() {
        return bodyWater;
    }

    public void setBodyWater(double bodyWater) {
        this.bodyWater = bodyWater;
    }

    public void knowNeeded(Customer customer) { // A function to know if someone looking to lose weight, gain muscle, or improve their overall body
        double BMI;
        double fatNeeded = 0;
        double carbNeeded = 0;
        double proteinNeeded = 0;

        height = height / 100;
        BMI = weight / (height * height);

        if (BMI < 18.5) {
            desire = String.valueOf(kDesires.GAIN_MUSCLE);
        } else if (BMI >= 18.5 && BMI < 24.9) {
            desire = String.valueOf(kDesires.NORMAL_BODY);
        } else if (BMI >= 25 && BMI < 29.9) {
            desire = String.valueOf(kDesires.LOSS_WEIGHT);
        }

        System.out.printf("Your BMI is %.2f%n", BMI);

        if (desire.equals("GAIN_MUSCLE")) {
            proteinNeeded = 2.25 * weight;     // in grams
            fatNeeded = weight;               // in grams
            carbNeeded = 1.7 * weight;       // in grams
            System.out.println("you’re underweight. You may not have the same health risks as people living with obesity, but being underweight could be putting you in other risk categories.");
        } else if (desire.equals("LOSS_WEIGHT")) {
            proteinNeeded = weight;           // in grams
            fatNeeded = 0.8 * weight;        // in grams
            carbNeeded = weight;            // in grams
            System.out.println("Your weight is above the 'normal range'. You may be interested in different ways to lose weight");
        } else if (desire.equals("NORMAL_BODY")) {
            proteinNeeded = 1.5 * weight;     // in grams
            fatNeeded = weight;              // in grams
            carbNeeded = 1.3 * weight;      // in grams
            System.out.println("You're within the ”normal BMI range”. Keeping your weight within this range lowers your risk of getting obesity-related deceases.");
        }

        System.out.println("You need to eat meals that contain" + proteinNeeded + "gram protein per day");
        System.out.println("You need to eat meals that contain " + fatNeeded + " gram fats per day");
        System.out.println("You need to eat meals that contain " + carbNeeded + " gram carb per day");

        //setters for the values
        this.proteinNeeded = proteinNeeded;
        this.fatNeeded = fatNeeded;
        this.carbNeeded = carbNeeded;

        //to display the actual value when needed
        height = height * 100;

    }

    public boolean canPerformInBody(Customer customer) {
        // Check if the customer has performed an InBody analysis in the last 30 days
        if (customer.getLastInBodyDate() == null) {
            // The customer has not performed an InBody analysis before, so it is allowed
            return true;
        } else {
            // Check if 30 days have passed since the last InBody analysis
            LocalDate nextAllowedInBodyDate = customer.getLastInBodyDate().plusDays(30);
            return LocalDate.now().isAfter(nextAllowedInBodyDate);
        }
    }
}

