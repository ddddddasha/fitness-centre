package app.servlets.fitness.services;

import app.servlets.fitness.arguments.subscription.*;
import app.servlets.fitness.dto.subscription.SubscriptionRequest;
import app.servlets.fitness.dto.subscription.SubscriptionResponse;
import app.servlets.fitness.entities.Subscription;
import app.servlets.fitness.mappers.SubscriptionMapper;
import app.servlets.fitness.repositories.subscription.SubscriptionRepository;
import app.servlets.fitness.services.subscription.SubscriptionService;
import app.servlets.fitness.services.subscription.SubscriptionServiceImpl;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@DisplayName("Testing SubscriptionService")
public class SubscriptionServiceImplTest {

    private SubscriptionService subscriptionService;
    @Mock
    private SubscriptionRepository subscriptionRepository;
    @Autowired
    private SubscriptionMapper subscriptionMapper;

    @BeforeEach
    void init() {
        subscriptionService = new SubscriptionServiceImpl(subscriptionRepository, subscriptionMapper);
    }

    @ParameterizedTest
    @DisplayName("create subscription")
    @ArgumentsSource(SubscriptionSaveArguments.class)
    void createSubscriptionTest(SubscriptionRequest subscriptionRequest, Subscription subscription, SubscriptionResponse expectedSubscriptionResponse) {
        when(subscriptionRepository.save(any(Subscription.class))).thenReturn(subscription);
        SubscriptionResponse actualSubscriptionResponse = subscriptionService.create(subscriptionRequest);
        assertEquals(expectedSubscriptionResponse, actualSubscriptionResponse);
    }

    @ParameterizedTest
    @DisplayName("find subscription by id")
    @ArgumentsSource(SubscriptionGetArguments.class)
    void findSubscriptionByIdTest(Subscription subscription, SubscriptionResponse expectedSubscriptionResponse) {
        when(subscriptionRepository.findById(any(Long.class))).thenReturn(Optional.of(subscription));
        SubscriptionResponse actualSubscriptionResponse = subscriptionService.findById(subscription.getId());
        assertEquals(expectedSubscriptionResponse, actualSubscriptionResponse);
    }

    @ParameterizedTest
    @DisplayName("read subscriptions")
    @ArgumentsSource(SubscriptionGetArguments.class)
    void readSubscriptions(Subscription subscription, SubscriptionResponse subscriptionResponse) {
        when(subscriptionRepository.findAll()).thenReturn(List.of(subscription));
        List<SubscriptionResponse> retrievedSubscriptions = subscriptionService.read();
        assertEquals(Collections.singletonList(subscriptionResponse), retrievedSubscriptions);
    }

    @ParameterizedTest
    @DisplayName("update subscription")
    @ArgumentsSource(SubscriptionUpdateArguments.class)
    void updateSubscriptionTest(SubscriptionRequest subscriptionRequest, Subscription subscription, SubscriptionResponse expectedSubscriptionResponse) {
        when(subscriptionRepository.findById(any(Long.class))).thenReturn(Optional.of(subscription));
        when(subscriptionRepository.save(any(Subscription.class))).thenReturn(subscription);
        SubscriptionResponse actualSubscriptionResponse = subscriptionService.update(subscription.getId(), subscriptionRequest);
        assertEquals(expectedSubscriptionResponse, actualSubscriptionResponse);
    }

    @Test
    @DisplayName("delete subscription")
    public void deleteSubscriptionTest() {
        subscriptionService.delete(12L);
        verify(subscriptionRepository).deleteById(12L);
    }

    @ParameterizedTest
    @DisplayName("update subscription with expected exception")
    @ArgumentsSource(SubscriptionInvalidUpdateArguments.class)
    void updateSubscriptionExpectedException(Long id, SubscriptionRequest subscriptionRequest) {
        when(subscriptionRepository.findById(any(Long.class))).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> subscriptionService.update(id, subscriptionRequest));
        verify(subscriptionRepository, never()).save(any());
    }

    @ParameterizedTest
    @DisplayName("find subscription by id for exception")
    @ArgumentsSource(SubscriptionInvalidArguments.class)
    void findSubscriptionByIdExpectedException(Subscription subscription) {
        when(subscriptionRepository.findById(any(Long.class))).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> subscriptionService.findById(subscription.getId()));
    }
}
