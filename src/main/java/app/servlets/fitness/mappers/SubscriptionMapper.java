package app.servlets.fitness.mappers;

import app.servlets.fitness.entities.Subscription;
import app.servlets.fitness.entities.enums.SubscriptionCategory;

public class SubscriptionMapper {

    public Subscription buildSubscription(long id, String subscriptionName, int subscriptionPrice, int subscriptionDaysNumber,
                                          Integer numberGuestVisitDays, int numberSubscriptionStopDays, String description){
        return Subscription.builder()
                .id(id)
                .subscriptionName(subscriptionName)
                .subscriptionPrice(subscriptionPrice)
                .subscriptionDaysNumber(subscriptionDaysNumber)
                .numberGuestVisitDays(numberGuestVisitDays)
                .numberSubscriptionStopDays(numberSubscriptionStopDays)
                .description(description)
                .build();
    }

    public Subscription buildSubscriptionForSearch(SubscriptionCategory subscriptionCategory, String subscriptionName, int subscriptionPrice, int subscriptionDaysNumber,
                                                   Integer numberGuestVisitDays, int numberSubscriptionStopDays, String description){
        return Subscription.builder()
                .subscriptionCategory(subscriptionCategory)
                .subscriptionName(subscriptionName)
                .subscriptionPrice(subscriptionPrice)
                .subscriptionDaysNumber(subscriptionDaysNumber)
                .numberGuestVisitDays(numberGuestVisitDays)
                .numberSubscriptionStopDays(numberSubscriptionStopDays)
                .description(description)
                .build();
    }
}
