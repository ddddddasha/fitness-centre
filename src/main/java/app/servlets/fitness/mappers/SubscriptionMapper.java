package app.servlets.fitness.mappers;

import app.servlets.fitness.dto.SubscriptionDto;
import app.servlets.fitness.dto.UserDto;
import app.servlets.fitness.entities.Subscription;
import app.servlets.fitness.entities.User;
import app.servlets.fitness.entities.enums.SubscriptionCategory;

import java.math.BigDecimal;

public class SubscriptionMapper {

    private static SubscriptionMapper instance;
    private final PurchaseMapper purchaseMapper = PurchaseMapper.getInstance();

    private SubscriptionMapper() {
    }

    public static SubscriptionMapper getInstance() {
        if (instance == null) {
            instance = new SubscriptionMapper();
        }
        return instance;
    }
    public Subscription buildSubscription(long id, String subscriptionName, BigDecimal subscriptionPrice, int subscriptionDaysNumber,
                                          Integer numberGuestVisitDays, int numberSubscriptionStopDays, String description){
        return Subscription.builder()
                .id(id)
                .subscriptionName(subscriptionName)
                .subscriptionPrice(subscriptionPrice)
                .subscriptionDaysNumber(subscriptionDaysNumber)
                .numberGuestVisitDays(numberGuestVisitDays)
                .numberSubscriptionStopDays(numberSubscriptionStopDays)
                .description(description)
                .build();
    }

    public Subscription buildSubscriptionForSearch(long id, SubscriptionCategory subscriptionCategory, String subscriptionName, BigDecimal subscriptionPrice, int subscriptionDaysNumber,
                                                   Integer numberGuestVisitDays, int numberSubscriptionStopDays, String description){
        return Subscription.builder()
                .id(id)
                .subscriptionCategory(subscriptionCategory)
                .subscriptionName(subscriptionName)
                .subscriptionPrice(subscriptionPrice)
                .subscriptionDaysNumber(subscriptionDaysNumber)
                .numberGuestVisitDays(numberGuestVisitDays)
                .numberSubscriptionStopDays(numberSubscriptionStopDays)
                .description(description)
                .build();
    }

    public SubscriptionDto buildSubscriptionDto(SubscriptionCategory subscriptionCategory, String subscriptionName, BigDecimal subscriptionPrice, int subscriptionDaysNumber,
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

    public SubscriptionDto mapToDto(Subscription subscription) {
        return SubscriptionDto.builder()
                .id(subscription.getId())
                .subscriptionCategory(subscription.getSubscriptionCategory())
                .subscriptionName(subscription.getSubscriptionName())
                .subscriptionPrice(subscription.getSubscriptionPrice())
                .subscriptionDaysNumber(subscription.getSubscriptionDaysNumber())
                .numberGuestVisitDays(subscription.getNumberGuestVisitDays())
                .numberSubscriptionStopDays(subscription.getNumberSubscriptionStopDays())
                .description(subscription.getDescription())
                .purchases(purchaseMapper.mapToDtoList(subscription.getPurchases()))
                .build();
    }
}
