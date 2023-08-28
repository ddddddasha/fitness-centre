package app.servlets.fitness.dto.purchase;

import app.servlets.fitness.dto.subscription.SubscriptionResponse;
import app.servlets.fitness.dto.user.UserResponse;
import app.servlets.fitness.entities.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseResponse {
    private Long id;
    private UserResponse userResponse;
    private SubscriptionResponse subscriptionResponse;
    private BigDecimal amountBYN;
    private LocalDateTime paymentDate;
    private PaymentStatus paymentStatus;
}
