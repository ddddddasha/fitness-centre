package app.servlets.fitness.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Subscription {
    private String id;
    private String subscriptionCategory;
    private String subscriptionName;
    private int subscriptionPrice;
    private int subscriptionPeriod;
    private int numberOfGuestVisits;
    private int maxSubscriptionStop;
    private String description;
}
