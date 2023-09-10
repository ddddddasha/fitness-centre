package app.servlets.fitness.arguments.subscription;

import app.servlets.fitness.dto.subscription.SubscriptionRequest;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static app.servlets.fitness.entities.enums.SubscriptionCategory.GYM;
import static java.math.BigDecimal.valueOf;

public class SubscriptionInvalidUpdateArguments implements ArgumentsProvider {

    public static final Long NON_EXISTENT_SUBSCRIPTION_ID  = 99L;
    public static final SubscriptionRequest SUBSCRIPTION_REQUEST = SubscriptionRequest.builder()
            .subscriptionCategory(GYM)
            .subscriptionName("Gym24")
            .subscriptionPrice(valueOf(115))
            .subscriptionDaysNumber(31)
            .numberGuestVisitDays(1)
            .numberSubscriptionStopDays(7)
            .description("Unlimited visit 1 month")
            .build();

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of(NON_EXISTENT_SUBSCRIPTION_ID, SUBSCRIPTION_REQUEST)
        );
    }
}
