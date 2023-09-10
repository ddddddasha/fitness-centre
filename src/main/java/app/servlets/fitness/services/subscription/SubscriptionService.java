package app.servlets.fitness.services.subscription;

import app.servlets.fitness.dto.subscription.SubscriptionRequest;
import app.servlets.fitness.dto.subscription.SubscriptionResponse;
import app.servlets.fitness.entities.Subscription;

import java.util.List;
import java.util.Optional;

public interface SubscriptionService {

    SubscriptionResponse create(SubscriptionRequest subscriptionRequest);
    SubscriptionResponse findById(Long id);
    Optional<Subscription> findSubscriptionByIdForPurchase(Long id);
    List<SubscriptionResponse> read();
    void delete(Long id);
    SubscriptionResponse update(Long id, SubscriptionRequest subscriptionRequest);
}
