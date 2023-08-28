package app.servlets.fitness.mappers;

import app.servlets.fitness.dto.subscription.SubscriptionRequest;
import app.servlets.fitness.dto.subscription.SubscriptionResponse;
import app.servlets.fitness.entities.Subscription;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SubscriptionMapper {
    public Subscription buildSubscription(SubscriptionRequest subscriptionRequest){
        return Subscription.builder()
                .subscriptionCategory(subscriptionRequest.getSubscriptionCategory())
                .subscriptionName(subscriptionRequest.getSubscriptionName())
                .subscriptionPrice(subscriptionRequest.getSubscriptionPrice())
                .subscriptionDaysNumber(subscriptionRequest.getSubscriptionDaysNumber())
                .numberGuestVisitDays(subscriptionRequest.getNumberGuestVisitDays())
                .numberSubscriptionStopDays(subscriptionRequest.getNumberSubscriptionStopDays())
                .description(subscriptionRequest.getDescription())
                .build();
    }

    public SubscriptionResponse buildSubscriptionResponse(Subscription subscription) {
        return SubscriptionResponse.builder()
                .subscriptionCategory(subscription.getSubscriptionCategory())
                .subscriptionName(subscription.getSubscriptionName())
                .subscriptionPrice(subscription.getSubscriptionPrice())
                .subscriptionDaysNumber(subscription.getSubscriptionDaysNumber())
                .numberGuestVisitDays(subscription.getNumberGuestVisitDays())
                .numberSubscriptionStopDays(subscription.getNumberSubscriptionStopDays())
                .description(subscription.getDescription())
                .build();

    }

    public List<SubscriptionResponse> buildSubscriptionsResponse(List<Subscription> subscriptions) {
        return subscriptions.stream()
                .map(this::buildSubscriptionResponse)
                .collect(Collectors.toList());
    }

    public Subscription updateSubscription(Subscription subscription, SubscriptionRequest subscriptionRequest) {
        subscription.setSubscriptionCategory(subscriptionRequest.getSubscriptionCategory());
        subscription.setSubscriptionName(subscriptionRequest.getSubscriptionName());
        subscription.setSubscriptionPrice(subscriptionRequest.getSubscriptionPrice());
        subscription.setSubscriptionDaysNumber(subscriptionRequest.getSubscriptionDaysNumber());
        subscription.setNumberGuestVisitDays(subscriptionRequest.getNumberGuestVisitDays());
        subscription.setNumberSubscriptionStopDays(subscriptionRequest.getNumberSubscriptionStopDays());
        subscription.setDescription(subscriptionRequest.getDescription());
        return subscription;
    }
}
