package app.servlets.fitness.entities;

import app.servlets.fitness.entities.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static app.servlets.fitness.util.Constants.ID;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.EnumType.STRING;

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
    private long id;

    @ManyToOne
    @JoinColumn(name = USER_ID)
    private User user;

    @ManyToOne(fetch=FetchType.LAZY, cascade=PERSIST)
    @JoinColumn(name = SUBSCRIPTION_ID)
    private Subscription subscription;

    @Column(name = AMOUNT_BYN)
    private BigDecimal amountBYN;

    @Column(name = PAYMENT_DATE)
    private LocalDateTime paymentDate;

    @Enumerated(STRING)
    @Column(name = PAYMENT_STATUS)
    private PaymentStatus paymentStatus;
}
