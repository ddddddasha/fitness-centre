package app.servlets.fitness.services;

import app.servlets.fitness.dto.PurchaseDto;
import app.servlets.fitness.entities.Purchase;
import app.servlets.fitness.repositories.PurchaseRepository;
import lombok.Builder;

import java.util.List;
import java.util.Optional;

@Builder
public class PurchaseServiceImpl implements PurchaseService{
    private final PurchaseRepository purchaseRepository;

    @Override
    public PurchaseDto savePurchase(PurchaseDto purchaseDto) {
        purchaseRepository.savePurchase(purchaseDto);
        return purchaseDto;
    }

    @Override
    public List<PurchaseDto> getUserPurchases(long userId) {
        return purchaseRepository.getUserPurchases(userId);
    }

    @Override
    public Optional<Purchase> deleteUserPurchaseById(long userId, long purchaseId) {
        return purchaseRepository.deleteUserPurchaseById(userId, purchaseId);
    }
}
