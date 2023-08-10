package app.servlets.fitness.creators;

import app.servlets.fitness.repositories.*;

public class RepositoryCreator {
    public UserRepository buildUserRepository() {
        return UserRepositoryImpl.builder()
                .build();
    }

    public SubscriptionRepository buildSubscriptionRepository() {
        return SubscriptionRepositoryImpl.builder()
                .build();
    }

    public PurchaseRepository buildPurchaseRepository() {
        return PurchaseRepositoryImpl.builder()
                .build();
    }
}
