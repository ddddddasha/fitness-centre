package app.servlets.fitness.services.purchase;

import app.servlets.fitness.dto.purchase.PurchaseRequest;
import app.servlets.fitness.dto.purchase.PurchaseResponse;
import app.servlets.fitness.entities.Purchase;
import app.servlets.fitness.entities.Subscription;
import app.servlets.fitness.entities.User;
import app.servlets.fitness.mappers.PurchaseMapper;
import app.servlets.fitness.repositories.purchase.PurchaseRepository;
import app.servlets.fitness.services.subscription.SubscriptionService;
import app.servlets.fitness.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

import static app.servlets.fitness.entities.enums.PaymentStatus.SUCCESSFUL;
import static app.servlets.fitness.util.Constants.*;
import static app.servlets.fitness.util.Constants.ERROR_SEARCH_EXCEPTION;
import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl implements PurchaseService{

    private final PurchaseRepository purchaseRepository;
    private final PurchaseMapper purchaseMapper;
    private final UserService userService;
    private final SubscriptionService subscriptionService;

    @Override
    @Transactional
    public PurchaseResponse create(PurchaseRequest purchaseRequest) {
        Purchase purchase = purchaseMapper.purchaseRequestToPurchase(purchaseRequest);
        Optional<User> optionalUser = userService.findUserByIdForPurchase(purchaseRequest.getUserId());
        Optional<Subscription> optionalSubscription = subscriptionService.findSubscriptionByIdForPurchase(purchaseRequest.getSubscriptionId());
        if(optionalUser.isPresent() && optionalSubscription.isPresent()){
            purchase.setPaymentStatus(SUCCESSFUL);
            purchase.setUser(optionalUser.get());
            purchase.setSubscription(optionalSubscription.get());
            return purchaseMapper.purchaseToPurchaseResponse(purchaseRepository.save(purchase));
        } else {
            throw new EntityNotFoundException(ERROR_SEARCH_EXCEPTION);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<PurchaseResponse> read() {
        List<Purchase> purchases = purchaseRepository.findAll();
        return purchaseMapper.purchasesToPurchaseResponses(purchases);
    }

    @Override
    @Transactional
    public PurchaseResponse update(Long id, PurchaseRequest purchaseRequest) { //НЕ ИЗМЕНЯЕТСЯ
        Purchase purchase = purchaseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(format(ERROR_SEARCH_PURCHASE_EXCEPTION, id)));
        purchaseMapper.updatePurchase(purchase, purchaseRequest);
        return purchaseMapper.purchaseToPurchaseResponse(purchaseRepository.save(purchase));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        purchaseRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public PurchaseResponse findById(Long id) {
        return purchaseRepository.findById(id)
                .map(purchaseMapper::purchaseToPurchaseResponse)
                .orElseThrow(() -> new EntityNotFoundException(format(ERROR_SEARCH_PURCHASE_EXCEPTION, id)));
    }
}
