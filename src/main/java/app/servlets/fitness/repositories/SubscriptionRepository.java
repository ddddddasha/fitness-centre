package app.servlets.fitness.repositories;

import app.servlets.fitness.entities.Subscription;
import app.servlets.fitness.entities.enums.SubscriptionCategory;

import java.util.List;
import java.util.Optional;

public interface SubscriptionRepository {
    Subscription createSubscription(Subscription subscription);

    List<Subscription> readSubscriptions();

    List<Subscription> findBySubscriptionCategory(SubscriptionCategory subscriptionCategory);

    Optional<Subscription> getById(long id);

    Optional<Subscription> deleteById(long id);

    Optional<Subscription> updateSubscription(Subscription subscription);

    SubscriptionCategory determineSubscriptionCategory(String category);
}
