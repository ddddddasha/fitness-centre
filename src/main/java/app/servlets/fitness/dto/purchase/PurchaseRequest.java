package app.servlets.fitness.dto.purchase;

import app.servlets.fitness.dto.subscription.SubscriptionRequest;
import app.servlets.fitness.dto.user.UserRequest;
import app.servlets.fitness.entities.enums.PaymentStatus;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class PurchaseRequest {

    private UserRequest userRequest;

    private SubscriptionRequest subscriptionRequest;

    @NotNull(message = "Amount cannot be null")
    @DecimalMin(value = "0.01", message = "Amount must be greater than or equal to 0.01")
    private BigDecimal amountBYN;

    @NotNull(message = "Payment date cannot be null")
    private LocalDateTime paymentDate;

    @NotNull(message = "Payment status cannot be null")
    private PaymentStatus paymentStatus;
}
