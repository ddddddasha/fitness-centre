package app.servlets.fitness.repositories;

import app.servlets.fitness.dto.SubscriptionDto;
import app.servlets.fitness.entities.Subscription;
import app.servlets.fitness.entities.User;
import app.servlets.fitness.entities.enums.SubscriptionCategory;
import app.servlets.fitness.mappers.SubscriptionMapper;
import app.servlets.fitness.util.EntityManagerHandler;
import lombok.Builder;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

import static app.servlets.fitness.util.Constants.*;

@Builder
public class SubscriptionRepositoryImpl implements SubscriptionRepository {

    private final SubscriptionMapper subscriptionMapper = SubscriptionMapper.getInstance();

    @Override
    public Subscription createSubscription(Subscription subscription) {
        try (EntityManagerHandler entityManagerHandler = new EntityManagerHandler()) {
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
        try (EntityManagerHandler entityManagerHandler = new EntityManagerHandler()) {
            EntityManager entityManager = entityManagerHandler.getEntityManager();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Subscription> criteriaQuery = criteriaBuilder.createQuery(Subscription.class);
            Root<Subscription> subscriptionRoot = criteriaQuery.from(Subscription.class);
            criteriaQuery.select(subscriptionRoot);

            Query query = entityManager.createQuery(criteriaQuery);
            return query.getResultList();
        }
    }

    @Override
    public List<Subscription> findBySubscriptionCategory(SubscriptionCategory subscriptionCategory) {
        try (EntityManagerHandler entityManagerHandler = new EntityManagerHandler()) {
            EntityManager entityManager = entityManagerHandler.getEntityManager();
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Subscription> criteriaQuery = criteriaBuilder.createQuery(Subscription.class);
            Root<Subscription> root = criteriaQuery.from(Subscription.class);

            criteriaQuery.select(root)
                    .where(criteriaBuilder.equal(root.get(SUBSCRIPTION_CATEGORY), subscriptionCategory));

            return entityManager.createQuery(criteriaQuery).getResultList();
        }
    }

    @Override
    public Optional<SubscriptionDto> getById(long id) {
        try (EntityManagerHandler entityManagerHandler = new EntityManagerHandler()) {
            EntityManager entityManager = entityManagerHandler.getEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Subscription subscription = entityManager.find(Subscription.class, id);
            SubscriptionDto subscriptionDto = subscriptionMapper.mapToDto(subscription);
            transaction.commit();
            return Optional.ofNullable(subscriptionDto);
        }
    }

    @Override
    public Optional<Subscription> deleteById(long id) {
        try (EntityManagerHandler entityManagerHandler = new EntityManagerHandler()) {
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
        try (EntityManagerHandler entityManagerHandler = new EntityManagerHandler()) {
            EntityManager entityManager = entityManagerHandler.getEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Subscription updatedSub = entityManager.find(Subscription.class, subscription.getId());
            updatedSub.setSubscriptionCategory(subscription.getSubscriptionCategory());
            updatedSub.setSubscriptionName(subscription.getSubscriptionName());
            updatedSub.setSubscriptionPrice(subscription.getSubscriptionPrice());
            updatedSub.setSubscriptionDaysNumber(subscription.getSubscriptionDaysNumber());
            updatedSub.setNumberGuestVisitDays(subscription.getNumberGuestVisitDays());
            updatedSub.setNumberSubscriptionStopDays(subscription.getNumberSubscriptionStopDays());
            updatedSub.setDescription(subscription.getDescription());
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
