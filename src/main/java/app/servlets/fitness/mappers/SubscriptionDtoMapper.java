package app.servlets.fitness.mappers;

import app.servlets.fitness.dto.SubscriptionDto;
import app.servlets.fitness.entities.Subscription;

public class SubscriptionDtoMapper {
    public SubscriptionDto buildSubscriptionDto( String subscriptionCategory, String subscriptionName, int subscriptionPrice, int subscriptionPeriod,
                                                 int numberOfGuestVisits, int maxSubscriptionStop, String description ){
        return SubscriptionDto.builder()
                .subscriptionCategory(subscriptionCategory)
                .subscriptionName(subscriptionName)
                .subscriptionPrice(subscriptionPrice)
                .subscriptionPeriod(subscriptionPeriod)
                .numberOfGuestVisits(numberOfGuestVisits)
                .maxSubscriptionStop(maxSubscriptionStop)
                .description(description)
                .build();
    }

    public Subscription toEntity(SubscriptionDto dto) {
        return Subscription.builder()
                .subscriptionCategory(dto.getSubscriptionCategory())
                .subscriptionName(dto.getSubscriptionName())
                .subscriptionPrice(dto.getSubscriptionPrice())
                .subscriptionPeriod(dto.getSubscriptionPeriod())
                .numberOfGuestVisits(dto.getNumberOfGuestVisits())
                .maxSubscriptionStop(dto.getMaxSubscriptionStop())
                .description(dto.getDescription())
                .build();

    }
}
