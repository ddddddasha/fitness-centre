package app.servlets.fitness.dto.subscription;
import app.servlets.fitness.entities.enums.SubscriptionCategory;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;

import static app.servlets.fitness.util.Constants.*;
import static app.servlets.fitness.util.Constants.INVALID_SUBSCRIPTION_PRICE;

@Data
@Builder
public class SubscriptionRequest {
    @NotNull(message = INVALID_SUBSCRIPTION_CATEGORY)
    private SubscriptionCategory subscriptionCategory;
    @NotBlank(message = INVALID_SUBSCRIPTION_NAME)
    private String subscriptionName;
    @NotNull(message = INVALID_SUBSCRIPTION_PRICE)
    private BigDecimal subscriptionPrice;
    private int subscriptionDaysNumber;
    private int numberGuestVisitDays;
    private int numberSubscriptionStopDays;
    private String description;
}
