package app.servlets.fitness.arguments.purchase;

import app.servlets.fitness.dto.purchase.PurchaseRequest;
import app.servlets.fitness.dto.purchase.PurchaseResponse;
import app.servlets.fitness.entities.Purchase;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static app.servlets.fitness.arguments.subscription.SubscriptionSaveArguments.SUBSCRIPTION;
import static app.servlets.fitness.arguments.subscription.SubscriptionSaveArguments.SUBSCRIPTION_RESPONSE;
import static app.servlets.fitness.arguments.user.UserSaveArguments.USER;
import static app.servlets.fitness.arguments.user.UserSaveArguments.USER_RESPONSE;
import static app.servlets.fitness.entities.enums.PaymentStatus.SUCCESSFUL;
import static java.math.BigDecimal.valueOf;
import static java.time.LocalDateTime.of;

public class PurchaseUpdateArguments implements ArgumentsProvider {

    public static final Purchase PURCHASE = Purchase.builder()
            .id(1L)
            .user(USER)
            .subscription(SUBSCRIPTION)
            .amount(valueOf(115))
            .paymentDate(of(2023, 9, 10, 18, 6, 30, 242599100))
            .paymentStatus(SUCCESSFUL)
            .build();
    public static final PurchaseRequest PURCHASE_REQUEST = PurchaseRequest.builder()
            .userId(1L)
            .subscriptionId(1L)
            .amount(valueOf(115))
            .paymentDate(of(2023, 8, 10, 18, 6, 30, 242599100))
            .paymentStatus(SUCCESSFUL)
            .build();
    public static final PurchaseResponse PURCHASE_RESPONSE = PurchaseResponse.builder()
            .id(1L)
            .userResponse(USER_RESPONSE)
            .subscriptionResponse(SUBSCRIPTION_RESPONSE)
            .amount(valueOf(115))
            .paymentDate(of(2023, 8, 10, 18, 6, 30, 242599100))
            .paymentStatus(SUCCESSFUL)
            .build();

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of(PURCHASE_REQUEST, PURCHASE, PURCHASE_RESPONSE)
        );
    }
}
