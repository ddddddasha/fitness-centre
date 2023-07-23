package app.servlets.fitness.services;

import app.servlets.fitness.entities.Subscription;
import app.servlets.fitness.entities.enums.SubscriptionCategory;
import app.servlets.fitness.exseptions.SubscriptionSearchException;
import app.servlets.fitness.repositories.SubscriptionRepository;
import lombok.Builder;

import java.util.List;

import static app.servlets.fitness.util.Constants.*;
import static app.servlets.fitness.util.Constants.SUBSCRIPTION_EDIT_EXCEPTION;

@Builder
public class SubscriptionServiceImpl implements SubscriptionService{
    private final SubscriptionRepository subscriptionRepository;

    @Override
    public Subscription createSubscription(Subscription subscription) {
        return subscriptionRepository.createSubscription(subscription);
    }

    @Override
    public Subscription getById(long id) throws SubscriptionSearchException {
        return subscriptionRepository.getById(id)
                .orElseThrow(() -> new SubscriptionSearchException(SUBSCRIPTION_SEARCH_EXCEPTION));
    }

    @Override
    public List<Subscription> readSubscriptions() {
        return subscriptionRepository.readSubscriptions();
    }

    @Override
    public Subscription deleteById(long id) throws SubscriptionSearchException {
        return subscriptionRepository.deleteById(id)
                .orElseThrow(()-> new SubscriptionSearchException(SUBSCRIPTION_DELETE_EXCEPTION));
    }

    @Override
    public Subscription updateSubscription(Subscription subscription) throws SubscriptionSearchException {
        return subscriptionRepository.updateSubscription(subscription)
                .orElseThrow(() -> new SubscriptionSearchException(SUBSCRIPTION_EDIT_EXCEPTION));
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
