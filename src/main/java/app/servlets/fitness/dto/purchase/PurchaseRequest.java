package app.servlets.fitness.dto.purchase;

import app.servlets.fitness.dto.subscription.SubscriptionRequest;
import app.servlets.fitness.dto.user.UserRequest;
import app.servlets.fitness.entities.enums.PaymentStatus;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static app.servlets.fitness.util.Constants.*;
import static app.servlets.fitness.util.Constants.INVALID_PAYMENT_STATUS;

@Data
@Builder
public class PurchaseRequest {
    private UserRequest userRequest;
    private SubscriptionRequest subscriptionRequest;
    @NotNull(message = INVALID_AMOUNT)
    private BigDecimal amountBYN;
    @NotNull(message = INVALID_PAYMENT_DATE)
    private LocalDateTime paymentDate;
    @NotNull(message = INVALID_PAYMENT_STATUS)
    private PaymentStatus paymentStatus;
}
