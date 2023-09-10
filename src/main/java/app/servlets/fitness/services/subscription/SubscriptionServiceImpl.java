package app.servlets.fitness.services.subscription;

import app.servlets.fitness.dto.subscription.SubscriptionRequest;
import app.servlets.fitness.dto.subscription.SubscriptionResponse;
import app.servlets.fitness.entities.Subscription;
import app.servlets.fitness.mappers.SubscriptionMapper;
import app.servlets.fitness.repositories.subscription.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

import static app.servlets.fitness.util.Constants.*;
import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final SubscriptionMapper subscriptionMapper;

    @Override
    @Transactional
    public SubscriptionResponse create(SubscriptionRequest subscriptionRequest) {
        Subscription subscription = subscriptionMapper.mapSubscriptionRequestToSubscription(subscriptionRequest);
        Subscription savedSubscription = subscriptionRepository.save(subscription);
        return subscriptionMapper.mapSubscriptionToSubscriptionResponse(savedSubscription);
    }

    @Override
    @Transactional(readOnly = true)
    public SubscriptionResponse findById(Long id) {
        return subscriptionRepository.findById(id)
                .map(subscriptionMapper::mapSubscriptionToSubscriptionResponse)
                .orElseThrow(() -> new EntityNotFoundException(format(USER_SEARCH_EXCEPTION, id)));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Subscription> findSubscriptionByIdForPurchase(Long id) {
        return subscriptionRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SubscriptionResponse> read() {
        List<Subscription> subscriptions = subscriptionRepository.findAll();
        return subscriptionMapper.mapSubscriptionsToSubscriptionResponses(subscriptions);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        subscriptionRepository.deleteById(id);
    }

    @Override
    @Transactional
    public SubscriptionResponse update(Long id, SubscriptionRequest subscriptionRequest) {
        Subscription subscription = subscriptionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(format(SUBSCRIPTION_SEARCH_EXCEPTION, id)));
        subscriptionMapper.updateSubscription(subscription, subscriptionRequest);
        Subscription updatedSubscription = subscriptionRepository.save(subscription);
        return subscriptionMapper.mapSubscriptionToSubscriptionResponse(updatedSubscription);
    }
}
