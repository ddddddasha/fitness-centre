package app.servlets.fitness.dto.subscription;

import app.servlets.fitness.dto.purchase.PurchaseResponse;
import app.servlets.fitness.entities.enums.SubscriptionCategory;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;


@Data
@Builder
public class SubscriptionResponse {

    private Long id;
    private SubscriptionCategory subscriptionCategory;
    private String subscriptionName;
    private BigDecimal subscriptionPrice;
    private Integer subscriptionDaysNumber;
    private Integer numberGuestVisitDays;
    private Integer numberSubscriptionStopDays;
    private String description;
    @JsonInclude(NON_EMPTY)
    private List<PurchaseResponse> purchases;
}
