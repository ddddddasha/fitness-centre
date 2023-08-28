package app.servlets.fitness.mappers;

import app.servlets.fitness.dto.purchase.PurchaseRequest;
import app.servlets.fitness.dto.purchase.PurchaseResponse;
import app.servlets.fitness.entities.Purchase;
import app.servlets.fitness.entities.Subscription;
import app.servlets.fitness.entities.User;
import app.servlets.fitness.entities.enums.PaymentStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PurchaseMapper {
    private final UserMapper userMapper;
    private final SubscriptionMapper subscriptionMapper;

    public Purchase buildPurchase(PurchaseRequest purchaseRequest){
        return Purchase.builder()
                .amountBYN(purchaseRequest.getAmountBYN())
                .paymentDate(LocalDateTime.now())
                .paymentStatus(PaymentStatus.SUCCESSFUL)
                .build();
    }

    public List<PurchaseResponse> buildPurchasesResponseForUser(List<Purchase> purchases) {
        return purchases.stream()
                .map(this::buildPurchaseResponseForUser)
                .collect(Collectors.toList());
    }

    private PurchaseResponse buildPurchaseResponseForUser(Purchase purchase) {
        return PurchaseResponse.builder()
                .id(purchase.getId())
                .subscriptionResponse(subscriptionMapper.buildSubscriptionResponse(purchase.getSubscription()))
                .amountBYN(purchase.getAmountBYN())
                .paymentDate(purchase.getPaymentDate())
                .paymentStatus(purchase.getPaymentStatus())
                .build();
    }

    public PurchaseResponse buildPurchaseResponse(Purchase purchase) {
        return PurchaseResponse.builder()
                .id(purchase.getId())
                .userResponse(userMapper.buildUserResponseWithoutPurchases(purchase.getUser()))
                .subscriptionResponse(subscriptionMapper.buildSubscriptionResponse(purchase.getSubscription()))
                .amountBYN(purchase.getAmountBYN())
                .paymentDate(purchase.getPaymentDate())
                .paymentStatus(purchase.getPaymentStatus())
                .build();
    }

    public PurchaseResponse makePurchase(Purchase purchase, Optional<User> optionalUser,
                                         Optional<Subscription> optionalSubscription)
    {
        if (optionalUser.isPresent() && optionalSubscription.isPresent()){
            purchase.setUser(optionalUser.get());
            purchase.setSubscription(optionalSubscription.get());
        }
        return buildPurchaseResponse(purchase);
    }

    public List<PurchaseResponse> buildPurchasesResponse(List<Purchase> purchases) {
        return purchases.stream()
                .map(this::buildPurchaseResponse)
                .collect(Collectors.toList());
    }

    public Purchase updatePurchase(Purchase purchase, PurchaseRequest purchaseRequest) {
        purchase.setAmountBYN(purchaseRequest.getAmountBYN());
        purchase.setPaymentDate(purchaseRequest.getPaymentDate());
        purchase.setPaymentStatus(purchaseRequest.getPaymentStatus());
        return purchase;
    }
}