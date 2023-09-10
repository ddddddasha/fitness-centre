package app.servlets.fitness.arguments.purchase;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static app.servlets.fitness.arguments.purchase.PurchaseSaveArguments.PURCHASE;
import static app.servlets.fitness.arguments.purchase.PurchaseSaveArguments.PURCHASE_RESPONSE;


public class PurchaseGetArguments implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of(PURCHASE, PURCHASE_RESPONSE)
        );
    }
}
