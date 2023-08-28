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

    @NotNull
    private SubscriptionCategory subscriptionCategory;

    @NotBlank
    private String subscriptionName;

    @NotNull
    private BigDecimal subscriptionPrice;

    @Min(value = 1)
    private int subscriptionDaysNumber;

    @Min(value = 0)
    private int numberGuestVisitDays;

    @Min(value = 0)
    private int numberSubscriptionStopDays;

    @Size(max = 255)
    private String description;
}
