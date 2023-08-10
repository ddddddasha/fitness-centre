package app.servlets.fitness.repositories;

import app.servlets.fitness.dto.PurchaseDto;
import app.servlets.fitness.entities.Purchase;
import app.servlets.fitness.entities.Subscription;
import app.servlets.fitness.entities.User;
import app.servlets.fitness.mappers.PurchaseMapper;
import app.servlets.fitness.util.EntityManagerHandler;
import lombok.Builder;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Builder
public class PurchaseRepositoryImpl implements PurchaseRepository {
    private final PurchaseMapper purchaseMapper = PurchaseMapper.getInstance();

    @Override
    public PurchaseDto savePurchase(PurchaseDto purchaseDto) {
        try (EntityManagerHandler entityManagerHandler = new EntityManagerHandler()) {
            EntityManager entityManager = entityManagerHandler.getEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Purchase purchase = purchaseMapper.mapToEntity(purchaseDto);
            Subscription subscription = entityManager.find(Subscription.class, purchaseDto.getSubscription().getId());
            User user = entityManager.find(User.class, purchaseDto.getUser().getId());
            purchase.setSubscription(subscription);
            purchase.setUser(user);
            entityManager.persist(purchase);
            transaction.commit();
            return purchaseDto;
        }
    }

    @Override
    public Optional<Purchase> getById(long id) {
        try (EntityManagerHandler entityManagerHandler = new EntityManagerHandler()) {
            EntityManager entityManager = entityManagerHandler.getEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Purchase purchase = entityManager.find(Purchase.class, id);
            transaction.commit();
            return Optional.ofNullable(purchase);
        }
    }

    @Override
    public Optional<Purchase> deleteUserPurchaseById(long userId, long purchaseId) {
        try (EntityManagerHandler entityManagerHandler = new EntityManagerHandler()) {
            EntityManager entityManager = entityManagerHandler.getEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Purchase> criteriaQuery = criteriaBuilder.createQuery(Purchase.class);
            Root<Purchase> purchaseRoot = criteriaQuery.from(Purchase.class);

            criteriaQuery.where(
                    criteriaBuilder.and(
                            criteriaBuilder.equal(purchaseRoot.get("id"), purchaseId),
                            criteriaBuilder.equal(purchaseRoot.get("user").get("id"), userId)
                    )
            );

            TypedQuery<Purchase> query = entityManager.createQuery(criteriaQuery);
            Purchase purchase = query.getSingleResult();
            entityManager.remove(purchase);
            transaction.commit();
            return Optional.of(purchase);
            /*try {
                Purchase purchase = query.getSingleResult();
                entityManager.remove(purchase);
                transaction.commit();
                return Optional.of(purchase);
            } catch (NoResultException ex) {
                transaction.rollback();
                return Optional.empty();
            }*/
        }
       /* try (EntityManagerHandler entityManagerHandler = new EntityManagerHandler()) {
            EntityManager entityManager = entityManagerHandler.getEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            User user = entityManager.find(User.class, userId);
            if (user != null) {
                Purchase purchase = entityManager.find(Purchase.class, purchaseId);
                if (purchase != null && purchase.getUser().getId() == userId) {
                    entityManager.remove(purchase);
                    transaction.commit();
                    return Optional.of(purchase);
                }
            }

            transaction.rollback();
            return Optional.empty();
        }*/
        /*try (EntityManagerHandler entityManagerHandler = new EntityManagerHandler()) {
            EntityManager entityManager = entityManagerHandler.getEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            // Найти пользователя по логину
            User user = entityManager.createQuery("SELECT u FROM User u WHERE u.login = :login", User.class)
                    .setParameter("login", login)
                    .getSingleResult();

            if (user != null) {
                // Найти покупку по ID и проверить, принадлежит ли она данному пользователю
                Purchase purchase = entityManager.find(Purchase.class, purchaseId);
                if (purchase != null && purchase.getUser().getId() == user.getId()) {
                    entityManager.remove(purchase);
                    transaction.commit();
                    return Optional.of(purchase);
                }
            }

            transaction.rollback();
            return Optional.empty();

        }*/
    }

    @Override
    public List<PurchaseDto> getUserPurchases(long userId) {
        try (EntityManagerHandler entityManagerHandler = new EntityManagerHandler()) {
            EntityManager entityManager = entityManagerHandler.getEntityManager();
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Purchase> criteriaQuery = criteriaBuilder.createQuery(Purchase.class);
            Root<Purchase> root = criteriaQuery.from(Purchase.class);

            criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("user").get("id"), userId));

            TypedQuery<Purchase> query = entityManager.createQuery(criteriaQuery);
            List<Purchase> purchases = query.getResultList();

            return purchaseMapper.mapToDtoList(purchases);
        }
    }
}
