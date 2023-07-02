package app.servlets.fitness.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubscriptionDto {
    private String subscriptionCategory;
    private String subscriptionName;
    private int subscriptionPrice;
    private int subscriptionPeriod;
    private int numberOfGuestVisits;
    private int maxSubscriptionStop;
    private String description;
}
