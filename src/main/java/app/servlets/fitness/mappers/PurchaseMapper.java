package app.servlets.fitness.mappers;

import app.servlets.fitness.dto.purchase.PurchaseRequest;
import app.servlets.fitness.dto.purchase.PurchaseResponse;
import app.servlets.fitness.entities.Purchase;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;


import java.util.List;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Component
@Mapper(componentModel = "spring", uses = {UserMapper.class, SubscriptionMapper.class}, nullValuePropertyMappingStrategy = IGNORE)
public interface PurchaseMapper {

    @Mapping(source = "userId", target = "user", ignore = true)
    @Mapping(source = "subscriptionId", target = "subscription", ignore = true)
    @Mapping(target = "paymentDate", expression = "java(java.time.LocalDateTime.now())")
    Purchase purchaseRequestToPurchase(PurchaseRequest purchaseRequest);
    @Mapping(source = "user", target = "userResponse", qualifiedByName = "mapToUserResponseForPurchase")
    @Mapping(source = "subscription", target = "subscriptionResponse", qualifiedByName = "mapToSubscriptionResponseForPurchase")
    PurchaseResponse purchaseToPurchaseResponse(Purchase purchase);
    List<PurchaseResponse> purchasesToPurchaseResponses(List<Purchase> purchases);
    void updatePurchase(@MappingTarget Purchase purchase, PurchaseRequest purchaseRequest);
}