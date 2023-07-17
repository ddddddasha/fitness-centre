package app.servlets.fitness.dto;

import app.servlets.fitness.entities.enums.SubscriptionCategory;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubscriptionDto {
    private SubscriptionCategory subscriptionCategory;
    private String subscriptionName;
    private int subscriptionPrice;
    private int subscriptionDaysNumber;
    private int numberGuestVisitDays;
    private int numberSubscriptionStopDays;
    private String description;
}
