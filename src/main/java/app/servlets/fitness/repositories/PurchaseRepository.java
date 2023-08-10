package app.servlets.fitness.repositories;

import app.servlets.fitness.dto.PurchaseDto;
import app.servlets.fitness.entities.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    PurchaseDto savePurchase(PurchaseDto purchaseDto);
    Optional<Purchase> getById(long id);
    Optional<Purchase> deleteUserPurchaseById(long userId, long purchaseId);
    List<PurchaseDto> getUserPurchases(long userId);
}
