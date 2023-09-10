package app.servlets.fitness.arguments.subscription;

import app.servlets.fitness.dto.subscription.SubscriptionRequest;
import app.servlets.fitness.dto.subscription.SubscriptionResponse;
import app.servlets.fitness.entities.Subscription;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static app.servlets.fitness.entities.enums.SubscriptionCategory.GYM;
import static app.servlets.fitness.entities.enums.SubscriptionCategory.YOGA;
import static java.math.BigDecimal.valueOf;

public class SubscriptionUpdateArguments implements ArgumentsProvider {

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
    public static final SubscriptionRequest SUBSCRIPTION_REQUEST = SubscriptionRequest.builder()
            .subscriptionCategory(YOGA)
            .subscriptionName("Group yoga classes")
            .subscriptionPrice(valueOf(80))
            .subscriptionDaysNumber(31)
            .numberGuestVisitDays(1)
            .numberSubscriptionStopDays(10)
            .description("Visit 3 times a week")
            .build();
    public static final SubscriptionResponse SUBSCRIPTION_RESPONSE = SubscriptionResponse.builder()
            .id(1L)
            .subscriptionCategory(YOGA)
            .subscriptionName("Group yoga classes")
            .subscriptionPrice(valueOf(80))
            .subscriptionDaysNumber(31)
            .numberGuestVisitDays(1)
            .numberSubscriptionStopDays(10)
            .description("Visit 3 times a week")
            .build();

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of(SUBSCRIPTION_REQUEST, SUBSCRIPTION, SUBSCRIPTION_RESPONSE)
        );
    }
}
