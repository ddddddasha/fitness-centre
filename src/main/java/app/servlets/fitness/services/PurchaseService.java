package app.servlets.fitness.services;

import app.servlets.fitness.dto.PurchaseDto;
import app.servlets.fitness.entities.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseService {
    PurchaseDto savePurchase(PurchaseDto purchaseDto);
    List<PurchaseDto> getUserPurchases(long userId);
    Optional<Purchase> deleteUserPurchaseById(long userId, long purchaseId);
}
