package app.servlets.fitness.creators;

import app.servlets.fitness.services.SubscriptionService;
import app.servlets.fitness.services.SubscriptionServiceImpl;
import app.servlets.fitness.services.UserService;
import app.servlets.fitness.services.UserServiceImpl;

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
}
