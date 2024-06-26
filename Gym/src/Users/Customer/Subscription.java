package Users.Customer;

import java.io.Serializable;
import java.time.LocalDate;

import Users.Customer.MemberShip;

public class Subscription implements Serializable {
    private int customerId;
    private String coachName;
    private MemberShip membership;
    private LocalDate startDate;
    private LocalDate endDate;
    private static final long serialVersionUID = -502369392812154238L;

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public MemberShip getMembership() {
        return membership;
    }

    public void setMembership(MemberShip membership) {
        this.membership = membership;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDAte(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Subscription(int customerId, String coachName, MemberShip membership, LocalDate startDate, LocalDate endDate) {
        this.coachName = coachName;
        this.membership = membership;
        this.startDate = startDate;
        this.endDate = getStartDate().plusMonths(membership.getNumberOfMonthsRegistered());
    }


    public String toString() {
        return "Ur Subscription {" +
                "Ur Id='" + customerId + '\'' +
                ", Ur coach name'" + coachName + '\'' +
                ", " + membership + '\'' +
                ", Subscription starts at'" + startDate + '\'' +
                ", Subscription ends at='" + endDate + '\'' +
                '}';
    }

}