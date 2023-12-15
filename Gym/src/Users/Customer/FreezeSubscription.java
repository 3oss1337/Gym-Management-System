package Users.Customer;

import java.time.LocalDate;

public class FreezeSubscription {
    private Subscription subscription;
    private int duration;

    public FreezeSubscription(Subscription subscription, int duration) {
        this.subscription = subscription;
        this.duration = duration;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LocalDate FreezeSub(Subscription subscription, int duration) {

        return subscription.getEndDate().plusWeeks(duration);
    }
}