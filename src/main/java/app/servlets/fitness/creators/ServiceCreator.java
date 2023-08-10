package app.servlets.fitness.creators;

import app.servlets.fitness.services.*;

public class ServiceCreator {
    public UserService buildUserService() {
        RepositoryCreator creator = new RepositoryCreator();
        return UserServiceImpl.builder()
                .userRepository(creator.buildUserRepository())
                .build();
    }

    public SubscriptionService buildSubscriptionService() {
        RepositoryCreator creator = new RepositoryCreator();
        return SubscriptionServiceImpl.builder()
                .subscriptionRepository(creator.buildSubscriptionRepository())
                .build();
    }

    public PurchaseService buildPurchaseService() {
        RepositoryCreator creator = new RepositoryCreator();
        return PurchaseServiceImpl.builder()
                .purchaseRepository(creator.buildPurchaseRepository())
                .build();
    }
}
