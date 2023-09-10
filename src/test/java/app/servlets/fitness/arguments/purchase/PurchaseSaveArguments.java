package app.servlets.fitness.arguments.purchase;

import app.servlets.fitness.dto.purchase.PurchaseRequest;
import app.servlets.fitness.dto.purchase.PurchaseResponse;
import app.servlets.fitness.dto.subscription.SubscriptionResponse;
import app.servlets.fitness.dto.user.UserResponse;
import app.servlets.fitness.entities.Purchase;
import app.servlets.fitness.entities.Subscription;
import app.servlets.fitness.entities.User;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.time.LocalDate;
import java.util.stream.Stream;

import static app.servlets.fitness.entities.enums.PaymentStatus.SUCCESSFUL;
import static app.servlets.fitness.entities.enums.Role.ADMIN;
import static app.servlets.fitness.entities.enums.SubscriptionCategory.GYM;
import static java.math.BigDecimal.valueOf;
import static java.time.LocalDateTime.of;

public class PurchaseSaveArguments implements ArgumentsProvider {

    public static final PurchaseRequest PURCHASE_REQUEST = PurchaseRequest.builder()
            .userId(1L)
            .subscriptionId(1L)
            .amount(valueOf(115))
            .build();
    public static final User USER = User.builder()
            .id(1L)
            .firstName("Dasha")
            .lastName("Zhelobkovich")
            .dateBirthday(LocalDate.parse("2003-07-11"))
            .login("dzhelobkovich@gmail.com")
            .password("admin")
            .role(ADMIN)
            .build();
    public static final Subscription SUBSCRIPTION = Subscription.builder()
            .id(1L)
            .subscriptionCategory(GYM)
            .subscriptionName("Gym24")
            .subscriptionPrice(valueOf(115))
            .subscriptionDaysNumber(31)
            .numberGuestVisitDays(1)
            .numberSubscriptionStopDays(7)
            .description("Unlimited visit 1 month")
            .build();
    public static final Purchase PURCHASE = Purchase.builder()
            .id(1L)
            .user(USER)
            .subscription(SUBSCRIPTION)
            .amount(valueOf(115))
            .paymentDate(of(2023, 9, 10, 18, 6, 30, 242599100))
            .paymentStatus(SUCCESSFUL)
            .build();
    public static final SubscriptionResponse SUBSCRIPTION_RESPONSE = SubscriptionResponse.builder()
            .id(1L)
            .subscriptionCategory(GYM)
            .subscriptionName("Gym24")
            .subscriptionPrice(valueOf(115))
            .subscriptionDaysNumber(31)
            .numberGuestVisitDays(1)
            .numberSubscriptionStopDays(7)
            .description("Unlimited visit 1 month")
            .build();
    public static final UserResponse USER_RESPONSE = UserResponse.builder()
            .id(1L)
            .firstName("Dasha")
            .lastName("Zhelobkovich")
            .dateBirthday(LocalDate.parse("2003-07-11"))
            .login("dzhelobkovich@gmail.com")
            .password("admin")
            .role(ADMIN)
            .build();
    public static final PurchaseResponse PURCHASE_RESPONSE = PurchaseResponse.builder()
            .id(1L)
            .userResponse(USER_RESPONSE)
            .subscriptionResponse(SUBSCRIPTION_RESPONSE)
            .amount(valueOf(115))
            .paymentDate(of(2023, 9, 10, 18, 6, 30, 242599100))
            .paymentStatus(SUCCESSFUL)
            .build();

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext){
        return Stream.of(
                Arguments.of(PURCHASE_REQUEST, PURCHASE, PURCHASE_RESPONSE, USER, SUBSCRIPTION)
        );
    }
}
