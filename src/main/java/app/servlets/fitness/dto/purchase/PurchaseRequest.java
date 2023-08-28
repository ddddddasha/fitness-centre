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

    @NotNull
    private BigDecimal amountBYN;

    @NotNull
    private LocalDateTime paymentDate;

    @NotNull
    private PaymentStatus paymentStatus;
}
