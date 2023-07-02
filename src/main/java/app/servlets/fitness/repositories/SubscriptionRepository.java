package app.servlets.fitness.repositories;

import app.servlets.fitness.entities.Subscription;

import java.util.List;

public interface SubscriptionRepository {
    Subscription createSubscription(Subscription subscription);

    List<Subscription> readSubscriptions();

    List<Subscription> findBySubscriptionCategory(String subscriptionCategory);

    Subscription getById(String id);

    boolean deleteById(String id);

    Subscription updateSubscription(Subscription subscription);

    boolean isIdExistsInDatabase(String id);
}
