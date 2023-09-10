package app.servlets.fitness.dto.purchase;

import app.servlets.fitness.dto.subscription.SubscriptionResponse;
import app.servlets.fitness.dto.user.UserResponse;
import app.servlets.fitness.entities.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseResponse {

    private Long id;
    @JsonInclude(NON_NULL)
    private UserResponse userResponse;
    @JsonInclude(NON_NULL)
    private SubscriptionResponse subscriptionResponse;
    private BigDecimal amount;
    private LocalDateTime paymentDate;
    private PaymentStatus paymentStatus;
}
