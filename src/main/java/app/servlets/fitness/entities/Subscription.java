package app.servlets.fitness.entities;

import app.servlets.fitness.entities.enums.SubscriptionCategory;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

import static app.servlets.fitness.util.Constants.*;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;

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
    private Long id;
    @Column(name = SUBSCRIPTION_CATEGORY_COLUMN)
    @Enumerated(STRING)
    private SubscriptionCategory subscriptionCategory;
    @Column(name = SUBSCRIPTION_NAME_COLUMN)
    private String subscriptionName;
    @Column(name = SUBSCRIPTION_PRICE_COLUMN)
    private BigDecimal subscriptionPrice;
    @Column(name = SUBSCRIPTION_DAYS_NUMBER_COLUMN)
    private Integer subscriptionDaysNumber;
    @Column(name = NUMBER_GUEST_VISIT_DAYS_COLUMN)
    private Integer numberGuestVisitDays;
    @Column(name = NUMBER_SUBSCRIPTION_STOP_DAYS_COLUMN)
    private Integer numberSubscriptionStopDays;
    @Column(name = DESCRIPTION)
    private String description;
    @OneToMany(mappedBy = SUBSCRIPTION, fetch = LAZY, cascade = ALL)
    private List<Purchase> purchases;
}

