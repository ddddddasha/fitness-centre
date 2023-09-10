package app.servlets.fitness.mappers;

import app.servlets.fitness.dto.subscription.SubscriptionRequest;
import app.servlets.fitness.dto.subscription.SubscriptionResponse;
import app.servlets.fitness.entities.Subscription;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Component
@Mapper(componentModel = "spring", uses = PurchaseMapper.class, nullValuePropertyMappingStrategy = IGNORE)
public interface SubscriptionMapper {

    Subscription mapSubscriptionRequestToSubscription(SubscriptionRequest subscriptionRequest);
    List<SubscriptionResponse> mapSubscriptionsToSubscriptionResponses(List<Subscription> subscriptions);
    SubscriptionResponse mapSubscriptionToSubscriptionResponse(Subscription subscription);
    @Named("mapToSubscriptionResponseForPurchase")
    @Mapping(target = "purchases", ignore = true)
    SubscriptionResponse mapToSubscriptionResponseForPurchase(Subscription subscription);
    void updateSubscription(@MappingTarget Subscription subscription, SubscriptionRequest subscriptionRequest);
}
