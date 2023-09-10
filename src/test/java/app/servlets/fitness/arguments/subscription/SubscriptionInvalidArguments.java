package app.servlets.fitness.arguments.subscription;

import app.servlets.fitness.entities.Subscription;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static app.servlets.fitness.entities.enums.SubscriptionCategory.GYM;
import static java.math.BigDecimal.valueOf;

public class SubscriptionInvalidArguments implements ArgumentsProvider {

    public static final Subscription SUBSCRIPTION = Subscription.builder()
            .id(99L)
            .subscriptionCategory(GYM)
            .subscriptionName("Gym24")
            .subscriptionPrice(valueOf(115))
            .subscriptionDaysNumber(31)
            .numberGuestVisitDays(1)
            .numberSubscriptionStopDays(7)
            .description("Unlimited visit 1 month")
            .build();

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of(SUBSCRIPTION)
        );
    }
}
