package app.servlets.fitness.services;

import app.servlets.fitness.entities.Subscription;
import app.servlets.fitness.entities.enums.SubscriptionCategory;

import java.util.List;

public interface SubscriptionService {
    Subscription createSubscription(Subscription subscription);
    Subscription getById(long id);
    List<Subscription> readSubscriptions();
    boolean deleteById(long id);
    Subscription updateSubscription(Subscription subscription);
    List<Subscription> findBySubscriptionCategory(SubscriptionCategory subscriptionCategory);
    SubscriptionCategory determineSubscriptionCategory(String category);
}
