package app.servlets.fitness.dto;

import app.servlets.fitness.entities.enums.PaymentStatus;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class PurchaseDto {
    private long purchaseId;
    private UserDto user;
    private SubscriptionDto subscription;
    private BigDecimal amountBYN;
    private LocalDateTime paymentDate;
    private PaymentStatus paymentStatus;
}
