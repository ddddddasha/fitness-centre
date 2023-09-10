package app.servlets.fitness.dto.purchase;

import app.servlets.fitness.entities.enums.PaymentStatus;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static app.servlets.fitness.util.Constants.*;

@Data
@Builder
public class PurchaseRequest {

    @NotNull(message = INVALID_USER_ID)
    private Long userId;
    @NotNull(message = INVALID_SUBSCRIPTION_ID)
    private Long subscriptionId;
    @NotNull(message = INVALID_AMOUNT)
    private BigDecimal amount;
    private LocalDateTime paymentDate;
    private PaymentStatus paymentStatus;
}
