package app.servlets.fitness.mappers;

import app.servlets.fitness.dto.purchase.PurchaseRequest;
import app.servlets.fitness.dto.purchase.PurchaseResponse;
import app.servlets.fitness.entities.Purchase;
import app.servlets.fitness.entities.Subscription;
import app.servlets.fitness.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Component
@Mapper(componentModel = "spring", uses = {UserMapper.class, SubscriptionMapper.class}, nullValuePropertyMappingStrategy = IGNORE)
public interface PurchaseMapper {
    @Mapping(target = "amountBYN", source = "purchaseRequest.amountBYN")
    @Mapping(target = "paymentDate", source = "purchaseRequest.paymentDate")
    @Mapping(target = "paymentStatus", source = "purchaseRequest.paymentStatus")
    Purchase purchaseRequestToPurchase(PurchaseRequest purchaseRequest);
    PurchaseResponse purchaseToPurchaseResponse(Purchase purchase);
    List<PurchaseResponse> purchasesToPurchaseResponses(List<Purchase> purchases);
    @Mapping(target = "amountBYN", source = "purchaseRequest.amountBYN")
    @Mapping(target = "paymentDate", source = "purchaseRequest.paymentDate")
    @Mapping(target = "paymentStatus", source = "purchaseRequest.paymentStatus")
    Purchase updatePurchase(Purchase purchase, PurchaseRequest purchaseRequest);
}