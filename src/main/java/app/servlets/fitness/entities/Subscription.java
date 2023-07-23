package app.servlets.fitness.entities;

import app.servlets.fitness.entities.enums.SubscriptionCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

import static app.servlets.fitness.util.Constants.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name=SUBSCRIPTION)
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name=ID, nullable = false, updatable = false)
    private long id;

    @Column(name = SUBSCRIPTION_CATEGORY_DB)
    @Enumerated(EnumType.STRING)
    private SubscriptionCategory subscriptionCategory;

    @Column(name = SUBSCRIPTION_NAME_DB)
    private String subscriptionName;

    @Column(name = SUBSCRIPTION_PRICE_DB)
    private BigDecimal subscriptionPrice;

    @Column(name = SUBSCRIPTION_DAYS_NUMBER_DB)
    private int subscriptionDaysNumber;

    @Column(name = NUMBER_GUEST_VISIT_DAYS_DB)
    private int numberGuestVisitDays;

    @Column(name = NUMBER_SUBSCRIPTION_STOP_DAYS_DB)
    private int numberSubscriptionStopDays;

    @Column(name = DESCRIPTION)
    private String description;
}

