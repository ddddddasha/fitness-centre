package app.servlets.fitness.mappers;

import app.servlets.fitness.entities.Subscription;

public class SubscriptionMapper {

    public Subscription buildSubscription(String id, String subscriptionName, int subscriptionPrice, int subscriptionPeriod,
                                          Integer numberOfGuestVisits, int maxSubscriptionStop, String description){
        return Subscription.builder()
                .id(id)
                .subscriptionName(subscriptionName)
                .subscriptionPrice(subscriptionPrice)
                .subscriptionPeriod(subscriptionPeriod)
                .numberOfGuestVisits(numberOfGuestVisits)
                .maxSubscriptionStop(maxSubscriptionStop)
                .description(description)
                .build();
    }

    public Subscription buildSubscriptionForSearch(String subscriptionCategory, String subscriptionName, int subscriptionPrice, int subscriptionPeriod,
                                                   Integer numberOfGuestVisits, int maxSubscriptionStop, String description){
        return Subscription.builder()
                .subscriptionCategory(subscriptionCategory)
                .subscriptionName(subscriptionName)
                .subscriptionPrice(subscriptionPrice)
                .subscriptionPeriod(subscriptionPeriod)
                .numberOfGuestVisits(numberOfGuestVisits)
                .maxSubscriptionStop(maxSubscriptionStop)
                .description(description)
                .build();
    }
}
