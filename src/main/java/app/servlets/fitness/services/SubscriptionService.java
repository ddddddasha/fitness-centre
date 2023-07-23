package app.servlets.fitness.services;

import app.servlets.fitness.entities.Subscription;
import app.servlets.fitness.entities.enums.SubscriptionCategory;
import app.servlets.fitness.exseptions.SubscriptionSearchException;

import java.util.List;

public interface SubscriptionService {
    Subscription createSubscription(Subscription subscription);
    Subscription getById(long id) throws SubscriptionSearchException;
    List<Subscription> readSubscriptions();
    Subscription deleteById(long id) throws SubscriptionSearchException;
    Subscription updateSubscription(Subscription subscription) throws SubscriptionSearchException;
    List<Subscription> findBySubscriptionCategory(SubscriptionCategory subscriptionCategory);
    SubscriptionCategory determineSubscriptionCategory(String category);
}
