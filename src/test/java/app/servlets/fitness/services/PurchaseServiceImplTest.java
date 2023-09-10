package app.servlets.fitness.services;

import app.servlets.fitness.arguments.purchase.PurchaseGetArguments;
import app.servlets.fitness.arguments.purchase.PurchaseInvalidArguments;
import app.servlets.fitness.arguments.purchase.PurchaseSaveArguments;
import app.servlets.fitness.arguments.purchase.PurchaseUpdateArguments;
import app.servlets.fitness.dto.purchase.PurchaseRequest;
import app.servlets.fitness.dto.purchase.PurchaseResponse;
import app.servlets.fitness.entities.Purchase;
import app.servlets.fitness.entities.Subscription;
import app.servlets.fitness.entities.User;
import app.servlets.fitness.mappers.PurchaseMapper;
import app.servlets.fitness.repositories.purchase.PurchaseRepository;
import app.servlets.fitness.services.purchase.PurchaseService;
import app.servlets.fitness.services.purchase.PurchaseServiceImpl;
import app.servlets.fitness.services.subscription.SubscriptionService;
import app.servlets.fitness.services.user.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@DisplayName("Testing PurchaseService")
public class PurchaseServiceImplTest {

    private PurchaseService purchaseService;
    @Mock
    private PurchaseRepository purchaseRepository;
    @Autowired
    private PurchaseMapper purchaseMapper;
    @Mock
    private UserService userService;
    @Mock
    private SubscriptionService subscriptionService;

    @BeforeEach
    void init() {
        purchaseService = new PurchaseServiceImpl(purchaseRepository, purchaseMapper, userService, subscriptionService);
    }

    @ParameterizedTest
    @DisplayName("save purchase")
    @ArgumentsSource(PurchaseSaveArguments.class)
    void createSubscriptionTest(PurchaseRequest purchaseRequest, Purchase purchase, PurchaseResponse expectedPurchaseResponse, User user, Subscription subscription) {
        when(userService.findUserByIdForPurchase(any(Long.class))).thenReturn(Optional.of(user));
        when(subscriptionService.findSubscriptionByIdForPurchase(any(Long.class))).thenReturn(Optional.of(subscription));
        when(purchaseRepository.save(any(Purchase.class))).thenReturn(purchase);
        PurchaseResponse actualPurchaseResponse = purchaseService.create(purchaseRequest);
        assertEquals(expectedPurchaseResponse, actualPurchaseResponse);
    }

    @ParameterizedTest
    @DisplayName("read purchases")
    @ArgumentsSource(PurchaseGetArguments.class)
    void readPurchases(Purchase purchase, PurchaseResponse expectedPurchaseResponse) {
        when(purchaseRepository.findAll()).thenReturn(List.of(purchase));
        List<PurchaseResponse> actualPurchases = purchaseService.read();
        assertEquals(Collections.singletonList(expectedPurchaseResponse), actualPurchases);
    }

    @ParameterizedTest
    @DisplayName("find purchase by id")
    @ArgumentsSource(PurchaseGetArguments.class)
    void findPurchaseByIdTest(Purchase purchase, PurchaseResponse expectedPurchaseResponse) {
        when(purchaseRepository.findById(any(Long.class))).thenReturn(Optional.of(purchase));
        PurchaseResponse actualPurchaseResponse = purchaseService.findById(purchase.getId());
        assertEquals(expectedPurchaseResponse, actualPurchaseResponse);
    }

    @ParameterizedTest
    @DisplayName("update purchase")
    @ArgumentsSource(PurchaseUpdateArguments.class)
    void updatePurchaseTest(PurchaseRequest purchaseRequest, Purchase purchase, PurchaseResponse expectedPurchaseResponse) {
        when(purchaseRepository.findById(any(Long.class))).thenReturn(Optional.of(purchase));
        when(purchaseRepository.save(any(Purchase.class))).thenReturn(purchase);
        PurchaseResponse actualPurchaseResponse = purchaseService.update(purchase.getId(), purchaseRequest);
        assertEquals(expectedPurchaseResponse, actualPurchaseResponse);
    }

    @Test
    @DisplayName("delete purchase")
    public void deletePurchaseTest() {
        purchaseService.delete(12L);
        verify(purchaseRepository).deleteById(12L);
    }

    @ParameterizedTest
    @DisplayName("find purchase by id exception")
    @ArgumentsSource(PurchaseInvalidArguments.class)
    void findPurchaseByIdExpectedException(Long id) {
        when(purchaseRepository.findById(any(Long.class))).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> purchaseService.findById(id));
    }
}
