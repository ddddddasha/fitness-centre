package app.servlets.fitness.dto;

import app.servlets.fitness.entities.enums.SubscriptionCategory;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class SubscriptionDto {
    private SubscriptionCategory subscriptionCategory;
    private String subscriptionName;
    private BigDecimal subscriptionPrice;
    private int subscriptionDaysNumber;
    private int numberGuestVisitDays;
    private int numberSubscriptionStopDays;
    private String description;
}
