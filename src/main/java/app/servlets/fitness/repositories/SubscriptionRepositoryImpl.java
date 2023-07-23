package app.servlets.fitness.repositories;

import app.servlets.fitness.entities.Subscription;
import app.servlets.fitness.entities.enums.SubscriptionCategory;
import app.servlets.fitness.mappers.SubscriptionMapper;
import app.servlets.fitness.util.EntityManagerHandler;
import lombok.Builder;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

import static app.servlets.fitness.util.Constants.*;
import static app.servlets.fitness.util.Constants.CATEGORY_COLUMN;

@Builder
public class SubscriptionRepositoryImpl implements SubscriptionRepository{

    private final SubscriptionMapper subscriptionMapper;

    @Override
    public Subscription createSubscription(Subscription subscription) {
        try(EntityManagerHandler entityManagerHandler = new EntityManagerHandler()){
            EntityManager entityManager = entityManagerHandler.getEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(subscription);
            transaction.commit();
            return subscription;
        }
    }

    @Override
    public List<Subscription> readSubscriptions() {
        try(EntityManagerHandler entityManagerHandler = new EntityManagerHandler()){
            EntityManager entityManager = entityManagerHandler.getEntityManager();
            TypedQuery<Subscription> query = entityManager.createQuery(READ_SUBSCRIPTIONS_QUERY, Subscription.class);
            return query.getResultList();
        }
    }

    @Override
    public List<Subscription> findBySubscriptionCategory(SubscriptionCategory subscriptionCategory) {
        try (EntityManagerHandler entityManagerHandler = new EntityManagerHandler()) {
            EntityManager entityManager = entityManagerHandler.getEntityManager();
            TypedQuery<Subscription> query = entityManager.createQuery(
                    GET_SUBSCRIPTIONS_BY_CATEGORY_QUERY,
                    Subscription.class
            );
            query.setParameter(CATEGORY_COLUMN, subscriptionCategory);
            return query.getResultList();
        }
    }

    @Override
    public Optional<Subscription> getById(long id) {
        try(EntityManagerHandler entityManagerHandler = new EntityManagerHandler()){
            EntityManager entityManager = entityManagerHandler.getEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Subscription subscription = entityManager.find(Subscription.class, id);
            transaction.commit();
            return Optional.ofNullable(subscription);
        }
    }

    @Override
    public Optional<Subscription> deleteById(long id) {
        try(EntityManagerHandler entityManagerHandler = new EntityManagerHandler()){
            EntityManager entityManager = entityManagerHandler.getEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Subscription subscription = entityManager.find(Subscription.class, id);
            entityManager.remove(subscription);
            transaction.commit();
            return Optional.of(subscription);
        }
    }

    public Optional<Subscription> updateSubscription(Subscription subscription) {
        try(EntityManagerHandler entityManagerHandler = new EntityManagerHandler()){
            EntityManager entityManager = entityManagerHandler.getEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(subscription);
            transaction.commit();
            return Optional.of(subscription);
        }
    }

    public SubscriptionCategory determineSubscriptionCategory(String category) {
        for (SubscriptionCategory subscriptionCategory : SubscriptionCategory.values()) {
            if (subscriptionCategory.getName().equals(category)) {
                return subscriptionCategory;
            }
        }
        return null;
    }
}
