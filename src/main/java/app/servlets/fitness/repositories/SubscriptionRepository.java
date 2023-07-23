package app.servlets.fitness.repositories;

import app.servlets.fitness.entities.Subscription;
import app.servlets.fitness.entities.enums.SubscriptionCategory;

import java.util.List;

public interface SubscriptionRepository {
    Subscription createSubscription(Subscription subscription);

    List<Subscription> readSubscriptions();

    List<Subscription> findBySubscriptionCategory(SubscriptionCategory subscriptionCategory);

    Subscription getById(long id);

    boolean deleteById(long id);

    Subscription updateSubscription(Subscription subscription);

    SubscriptionCategory determineSubscriptionCategory(String category);
}
