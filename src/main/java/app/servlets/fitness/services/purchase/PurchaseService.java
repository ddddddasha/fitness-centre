package app.servlets.fitness.services.purchase;

import app.servlets.fitness.dto.purchase.PurchaseRequest;
import app.servlets.fitness.dto.purchase.PurchaseResponse;

import java.util.List;

public interface PurchaseService {
    PurchaseResponse create(PurchaseRequest purchaseRequest);

    List<PurchaseResponse> read();

    PurchaseResponse update(Long id, PurchaseRequest purchaseRequest);

    boolean delete(Long id);

    PurchaseResponse findByID(Long id);
}
