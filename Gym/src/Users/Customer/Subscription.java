package Users.Customer;

import java.time.LocalDate;
import Users.Customer.MemberShip;

public class Subscription {
    private int customerId;
    private int coachId;
    private MemberShip membership;
    private LocalDate startDate;
    private LocalDate endDate;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCoachId() {
        return coachId;
    }

    public void setCoachId(int coachId) {
        this.coachId = coachId;
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

    public Subscription(int customerId, int coachId, MemberShip membership, LocalDate startDate, LocalDate endDate) {
        this.customerId = customerId;
        this.coachId = coachId;
        this.membership = membership;
        this.startDate = LocalDate.now();
        this.endDate = getStartDate().plusMonths(membership.getNumberOfMonthsRegistered());
    }
    public Subscription(int customerId,int coachId,MemberShip membership)
    {
        this.customerId=customerId;
        this.coachId=coachId;
        this.membership=membership;
    }

    public String toString() {
        return "Ur Subscription {" +
                "Ur Id='" + customerId + '\'' +
                ", Ur coach Id'" + coachId + '\'' +
                ", Ur Member Ship is'" + membership + '\'' +
                ", Subscription starts at'" + startDate + '\'' +
                ", Subscription ends at='" + endDate + '\'' +
                '}';
    }

}