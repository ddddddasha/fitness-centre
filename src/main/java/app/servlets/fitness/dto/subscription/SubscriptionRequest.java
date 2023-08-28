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
    @DecimalMin(value = "0.01", message = "Subscription price must be greater than or equal to 0.01")
    private BigDecimal subscriptionPrice;

    @Min(value = 1, message = "Subscription days number must be at least 1")
    private int subscriptionDaysNumber;

    @Min(value = 0, message = "Number of guest visit days cannot be negative")
    private int numberGuestVisitDays;

    @Min(value = 0, message = "Number of subscription stop days cannot be negative")
    private int numberSubscriptionStopDays;

    @Size(max = 255, message = "Description length must not exceed 255 characters")
    private String description;
}
