package app.servlets.fitness.services;

import app.servlets.fitness.entities.Subscription;
import app.servlets.fitness.entities.enums.SubscriptionCategory;
import app.servlets.fitness.repositories.SubscriptionRepository;
import lombok.Builder;

import java.util.List;

@Builder
public class SubscriptionServiceImpl implements SubscriptionService{
    private final SubscriptionRepository subscriptionRepository;

    @Override
    public Subscription createSubscription(Subscription subscription) {
        return subscriptionRepository.createSubscription(
                new Subscription(subscription.getId(), subscription.getSubscriptionCategory(), subscription.getSubscriptionName(),
                        subscription.getSubscriptionPrice(), subscription.getSubscriptionDaysNumber(),
                        subscription.getNumberGuestVisitDays(), subscription.getNumberSubscriptionStopDays(),
                        subscription.getDescription())
        );
    }

    @Override
    public Subscription getById(long id) {
        return subscriptionRepository.getById(id);
    }

    @Override
    public List<Subscription> readSubscriptions() {
        return subscriptionRepository.readSubscriptions();
    }

    @Override
    public boolean deleteById(long id) {
        return subscriptionRepository.deleteById(id);
    }

    @Override
    public Subscription updateSubscription(Subscription subscription) {
        return subscriptionRepository.updateSubscription(subscription);
    }

    @Override
    public List<Subscription> findBySubscriptionCategory(SubscriptionCategory subscriptionCategory) {
        return subscriptionRepository.findBySubscriptionCategory(subscriptionCategory);
    }

    @Override
    public SubscriptionCategory determineSubscriptionCategory(String category) {
        return subscriptionRepository.determineSubscriptionCategory(category);
    }
}
