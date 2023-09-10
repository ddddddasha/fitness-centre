package app.servlets.fitness.entities;

import app.servlets.fitness.entities.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static app.servlets.fitness.util.Constants.*;
import static app.servlets.fitness.util.Constants.AMOUNT;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = PURCHASE_TABLE)
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ID, nullable = false, updatable = false)
    private Long id;
    @ManyToOne(fetch = LAZY, cascade = PERSIST)
    @JoinColumn(name = USER_ID)
    private User user;
    @ManyToOne(fetch = LAZY, cascade = PERSIST)
    @JoinColumn(name = SUBSCRIPTION_ID)
    private Subscription subscription;
    @Column(name = AMOUNT)
    private BigDecimal amount;
    @Column(name = PAYMENT_DATE)
    private LocalDateTime paymentDate;
    @Enumerated(STRING)
    @Column(name = PAYMENT_STATUS)
    private PaymentStatus paymentStatus;
}
