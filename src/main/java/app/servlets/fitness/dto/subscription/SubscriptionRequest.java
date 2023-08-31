package app.servlets.fitness.dto.subscription;
import app.servlets.fitness.entities.enums.SubscriptionCategory;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@Builder
public class SubscriptionRequest {

    private Long id;

    @NotNull(message = "Subscription category cannot be null")
    private SubscriptionCategory subscriptionCategory;

    @NotBlank(message = "Subscription name cannot be blank")
    private String subscriptionName;

    @NotNull(message = "Subscription price cannot be null")
    private BigDecimal subscriptionPrice;

    private int subscriptionDaysNumber;

    private int numberGuestVisitDays;

    private int numberSubscriptionStopDays;

    private String description;
}
