package app.servlets.fitness.mappers;

import app.servlets.fitness.dto.SubscriptionDto;
import app.servlets.fitness.entities.Subscription;
import app.servlets.fitness.entities.enums.SubscriptionCategory;

public class SubscriptionDtoMapper {
    public SubscriptionDto buildSubscriptionDto(SubscriptionCategory subscriptionCategory, String subscriptionName, int subscriptionPrice, int subscriptionDaysNumber,
                                                int numberGuestVisitDays, int numberSubscriptionStopDays, String description ){
        return SubscriptionDto.builder()
                .subscriptionCategory(subscriptionCategory)
                .subscriptionName(subscriptionName)
                .subscriptionPrice(subscriptionPrice)
                .subscriptionDaysNumber(subscriptionDaysNumber)
                .numberGuestVisitDays(numberGuestVisitDays)
                .numberSubscriptionStopDays(numberSubscriptionStopDays)
                .description(description)
                .build();
    }

    public Subscription toEntity(SubscriptionDto dto) {
        return Subscription.builder()
                .subscriptionCategory(dto.getSubscriptionCategory())
                .subscriptionName(dto.getSubscriptionName())
                .subscriptionPrice(dto.getSubscriptionPrice())
                .subscriptionDaysNumber(dto.getSubscriptionDaysNumber())
                .numberGuestVisitDays(dto.getNumberGuestVisitDays())
                .numberSubscriptionStopDays(dto.getNumberSubscriptionStopDays())
                .description(dto.getDescription())
                .build();

    }
}
