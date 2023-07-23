package app.servlets.fitness.creators;

import app.servlets.fitness.mappers.SubscriptionMapper;
import app.servlets.fitness.mappers.UserMapper;
import app.servlets.fitness.repositories.SubscriptionRepository;
import app.servlets.fitness.repositories.SubscriptionRepositoryImpl;
import app.servlets.fitness.repositories.UserRepository;
import app.servlets.fitness.repositories.UserRepositoryImpl;

public class RepositoryCreator {

    public UserRepository buildUserRepository() {
        return UserRepositoryImpl.builder()
                .userMapper(new UserMapper())
                .build();
    }

    public SubscriptionRepository buildSubscriptionRepository() {
        return SubscriptionRepositoryImpl.builder()
                .subscriptionMapper(new SubscriptionMapper())
                .build();
    }
}
