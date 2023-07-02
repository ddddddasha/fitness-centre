package app.servlets.fitness.services;

import app.servlets.fitness.entities.Subscription;

import java.util.List;

public interface SubscriptionService {
    Subscription createSubscription(Subscription subscription);
    Subscription getById(String id);
    List<Subscription> readSubscriptions();
    boolean deleteById(String id);
    Subscription updateSubscription(Subscription subscription);
    boolean isIdExistsInDatabase(String id);
    List<Subscription> findBySubscriptionCategory(String subscriptionCategory);
}
