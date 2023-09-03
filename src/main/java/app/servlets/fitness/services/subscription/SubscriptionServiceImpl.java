package app.servlets.fitness.services.subscription;

import app.servlets.fitness.dto.subscription.SubscriptionRequest;
import app.servlets.fitness.dto.subscription.SubscriptionResponse;
import app.servlets.fitness.entities.Subscription;
import app.servlets.fitness.exseptions.subscription.SubscriptionNotFoundException;
import app.servlets.fitness.mappers.SubscriptionMapper;
import app.servlets.fitness.repositories.subscription.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static app.servlets.fitness.util.Constants.*;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService{
    private final SubscriptionRepository subscriptionRepository;
    private final SubscriptionMapper subscriptionMapper;

    @Override
    public SubscriptionResponse create(SubscriptionRequest subscriptionRequest) {
        Subscription subscription = subscriptionMapper.mapSubscriptionRequestToSubscription(subscriptionRequest);
        Optional<Subscription> optionalSubscription = Optional.of(subscriptionRepository.save(subscription));
        return optionalSubscription.map(subscriptionMapper::mapSubscriptionToSubscriptionResponse)
                .orElseThrow(() -> new SubscriptionNotFoundException(SUBSCRIPTION_CREATION_EXCEPTION));
    }

    @Override
    public SubscriptionResponse findById(Long id) {
        Subscription subscription = subscriptionRepository.findById(id)
                .orElseThrow(() -> new SubscriptionNotFoundException(SUBSCRIPTION_SEARCH_EXCEPTION + id));
        return subscriptionMapper.mapSubscriptionToSubscriptionResponse(subscription);
    }

    @Override
    public Optional<Subscription> findSubscriptionByIdForPurchase(Long id) {
        return subscriptionRepository.findById(id);
    }

    @Override
    public List<SubscriptionResponse> read() {
        List<Subscription> subscriptions = subscriptionRepository.findAll();
        return subscriptionMapper.mapSubscriptionsToSubscriptionResponses(subscriptions);
    }

    @Override
    public boolean delete(Long id) {
        Optional<Subscription> optionalSubscription = subscriptionRepository.findById(id);
        optionalSubscription.ifPresent(subscriptionRepository::delete);
        return optionalSubscription.isPresent();
    }

    @Override
    public SubscriptionResponse update(Long id, SubscriptionRequest subscriptionRequest) {
        Subscription subscription = subscriptionRepository.findById(id)
                .orElseThrow(() -> new SubscriptionNotFoundException(SUBSCRIPTION_SEARCH_EXCEPTION + id));
        subscriptionMapper.updateSubscription(subscription, subscriptionRequest);//ТУТ НЕПРАВИЛЬНО ПЕРЕДЕЛАТЬ НЕ ЛОГИЧНО
        return subscriptionMapper.mapSubscriptionToSubscriptionResponse(subscription);
    }

}
