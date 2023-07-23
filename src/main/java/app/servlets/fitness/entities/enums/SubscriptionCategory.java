package app.servlets.fitness.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SubscriptionCategory {
    GYM("GYM"),
    YOGA("YOGA"),
    PILATES("PILATES"),
    SPA("SPA");

    private final String name;
}
