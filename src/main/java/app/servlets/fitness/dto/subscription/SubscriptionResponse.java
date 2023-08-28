package app.servlets.fitness.dto.subscription;

import app.servlets.fitness.dto.purchase.PurchaseResponse;
import app.servlets.fitness.entities.enums.SubscriptionCategory;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;


@Data
@Builder
public class SubscriptionResponse {
    private Long id;
    private SubscriptionCategory subscriptionCategory;
    private String subscriptionName;
    private BigDecimal subscriptionPrice;
    private int subscriptionDaysNumber;
    private int numberGuestVisitDays;
    private int numberSubscriptionStopDays;
    private String description;
    private List<PurchaseResponse> purchases;
}
