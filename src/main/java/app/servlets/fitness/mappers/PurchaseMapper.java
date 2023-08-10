package app.servlets.fitness.mappers;

import app.servlets.fitness.dto.PurchaseDto;
import app.servlets.fitness.dto.SubscriptionDto;
import app.servlets.fitness.dto.UserDto;
import app.servlets.fitness.entities.Purchase;
import app.servlets.fitness.entities.Subscription;
import app.servlets.fitness.entities.enums.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class PurchaseMapper {
    private static PurchaseMapper instance;
    private PurchaseMapper() {
    }

    public static PurchaseMapper getInstance() {
        if (instance == null) {
            instance = new PurchaseMapper();
        }
        return instance;
    }

    public PurchaseDto buildPurchaseDto(UserDto userDto, SubscriptionDto subscriptionDto, BigDecimal amountBYN, LocalDateTime paymentDate, PaymentStatus paymentStatus){
        return PurchaseDto.builder()
                .user(userDto)
                .subscription(subscriptionDto)
                .amountBYN(subscriptionDto.getSubscriptionPrice())
                .paymentDate(LocalDateTime.now())
                .paymentStatus(PaymentStatus.SUCCESSFUL)
                .build();
    }
    public PurchaseDto mapToDto(Purchase purchase) {
        SubscriptionDto subscriptionDto = SubscriptionDto.builder()
                .subscriptionName(purchase.getSubscription().getSubscriptionName())
                .subscriptionPrice(purchase.getSubscription().getSubscriptionPrice())
                .subscriptionDaysNumber(purchase.getSubscription().getSubscriptionDaysNumber())
                .numberGuestVisitDays(purchase.getSubscription().getNumberGuestVisitDays())
                .numberSubscriptionStopDays(purchase.getSubscription().getNumberSubscriptionStopDays())
                .description(purchase.getSubscription().getDescription())
                .build();

        return PurchaseDto.builder()
                .subscription(subscriptionDto)
                .paymentDate(purchase.getPaymentDate())
                .paymentStatus(purchase.getPaymentStatus())
                .build();
    }

    public List<PurchaseDto> mapToDtoList(List<Purchase> purchases) {
        return purchases.stream()
                .map(PurchaseMapper.getInstance()::mapToDto)
                .collect(Collectors.toList());
    }

    public Purchase mapToEntity(PurchaseDto purchaseDto) {
        Purchase purchase = new Purchase();
        SubscriptionDto subscriptionDto = purchaseDto.getSubscription();
        Subscription subscription = new Subscription();
        subscription.setSubscriptionName(subscriptionDto.getSubscriptionName());
        subscription.setSubscriptionPrice(subscriptionDto.getSubscriptionPrice());
        subscription.setSubscriptionDaysNumber(subscriptionDto.getSubscriptionDaysNumber());
        subscription.setNumberGuestVisitDays(subscriptionDto.getNumberGuestVisitDays());
        subscription.setNumberSubscriptionStopDays(subscriptionDto.getNumberSubscriptionStopDays());
        subscription.setDescription(subscriptionDto.getDescription());
        purchase.setSubscription(subscription);
        purchase.setAmountBYN(purchaseDto.getAmountBYN());
        purchase.setPaymentDate(purchaseDto.getPaymentDate());
        purchase.setPaymentStatus(purchaseDto.getPaymentStatus());
        return purchase;
    }

    public  List<Purchase> mapToEntityList(List<PurchaseDto> purchaseDto) {
        return purchaseDto.stream()
                .map(PurchaseMapper.getInstance()::mapToEntity)
                .collect(Collectors.toList());
    }
}