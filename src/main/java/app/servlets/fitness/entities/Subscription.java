package app.servlets.fitness.entities;

import app.servlets.fitness.entities.enums.SubscriptionCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Subscription {
    private long id;
    private SubscriptionCategory subscriptionCategory;
    private String subscriptionName;
    private int subscriptionPrice;
    private int subscriptionDaysNumber;
    private int numberGuestVisitDays;
    private int numberSubscriptionStopDays;
    private String description;
}
