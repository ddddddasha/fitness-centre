package app.servlets.fitness.services;

import app.servlets.fitness.entities.Subscription;
import app.servlets.fitness.repositories.SubscriptionRepository;
import app.servlets.fitness.repositories.SubscriptionRepositoryImpl;

import java.util.List;
import java.util.UUID;

public class SubscriptionServiceImpl implements SubscriptionService{
    private final SubscriptionRepository subscriptionRepository = new SubscriptionRepositoryImpl();

    @Override
    public Subscription createSubscription(Subscription subscription) {
        return subscriptionRepository.createSubscription(
                new Subscription(generateUniqueId(), subscription.getSubscriptionCategory(), subscription.getSubscriptionName(),
                        subscription.getSubscriptionPrice(), subscription.getSubscriptionPeriod(),
                        subscription.getNumberOfGuestVisits(), subscription.getMaxSubscriptionStop(),
                        subscription.getDescription())
        );
    }

    @Override
    public Subscription getById(String id) {
        return subscriptionRepository.getById(id);
    }

    @Override
    public List<Subscription> readSubscriptions() {
        return subscriptionRepository.readSubscriptions();
    }

    @Override
    public boolean deleteById(String id) {
        return subscriptionRepository.deleteById(id);
    }

    @Override
    public Subscription updateSubscription(Subscription subscription) {
        return subscriptionRepository.updateSubscription(subscription);
    }

    @Override
    public boolean isIdExistsInDatabase(String id) {
        return subscriptionRepository.isIdExistsInDatabase(id);
    }

    @Override
    public List<Subscription> findBySubscriptionCategory(String subscriptionCategory) {
        return subscriptionRepository.findBySubscriptionCategory(subscriptionCategory);
    }

    private String generateUniqueId() {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
        while (isIdExistsInDatabase(id)) {
            uuid = UUID.randomUUID();
            id = uuid.toString();
        }
        return id;
    }
}
