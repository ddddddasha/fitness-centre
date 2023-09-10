package app.servlets.fitness.dto.subscription;
import app.servlets.fitness.entities.enums.SubscriptionCategory;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;

import static app.servlets.fitness.util.Constants.*;

@Data
@Builder
public class SubscriptionRequest {

    @NotNull(message = INVALID_SUBSCRIPTION_CATEGORY)
    private SubscriptionCategory subscriptionCategory;
    @NotBlank(message = INVALID_SUBSCRIPTION_NAME)
    private String subscriptionName;
    @NotNull(message = INVALID_SUBSCRIPTION_PRICE)
    private BigDecimal subscriptionPrice;
    private Integer subscriptionDaysNumber;
    private Integer numberGuestVisitDays;
    private Integer numberSubscriptionStopDays;
    private String description;
}
