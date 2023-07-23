package app.servlets.fitness.repositories;

import app.servlets.fitness.entities.User;
import app.servlets.fitness.mappers.UserMapper;
import app.servlets.fitness.util.EntityManagerHandler;
import lombok.Builder;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

import static app.servlets.fitness.util.Constants.*;

@Builder
public class UserRepositoryImpl implements UserRepository{
    private final UserMapper userMapper;

    @Override
    public User createUser(User user) {
        try (EntityManagerHandler entityManagerHandler = new EntityManagerHandler()) {
            EntityManager entityManager = entityManagerHandler.getEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(user);
            transaction.commit();
            return user;
        }
    }

    @Override
    public List<User> readUsers() {
        try (EntityManagerHandler entityManagerHandler = new EntityManagerHandler()) {
            EntityManager entityManager = entityManagerHandler.getEntityManager();
            TypedQuery<User> query = entityManager.createQuery(READ_USERS_QUERY, User.class);
            return query.getResultList();
        }
    }

    @Override
    public Optional<User> getByLogin(String login) {
        try(EntityManagerHandler entityManagerHandler = new EntityManagerHandler()){
            EntityManager entityManager = entityManagerHandler.getEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<User> query = entityManager.createQuery(GET_USER_BY_LOGIN_QUERY, User.class)
                    .setParameter(LOGIN, login);

            User user = query.getSingleResult();
            transaction.commit();
            return Optional.ofNullable(user);
        }
    }

    @Override
    public Optional<User> deleteById(long id) {
        try (EntityManagerHandler entityManagerHandler = new EntityManagerHandler()) {
            EntityManager entityManager = entityManagerHandler.getEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            User user = entityManager.find(User.class, id);
            entityManager.remove(user);
            transaction.commit();
            return Optional.of(user);
        }
    }

    @Override
    public Optional<User> getById(long id) {
        try (EntityManagerHandler entityManagerHandler = new EntityManagerHandler()) {
            EntityManager entityManager = entityManagerHandler.getEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            User user = entityManager.find(User.class, id);
            transaction.commit();
            return Optional.ofNullable(user);
        }
    }

    @Override
    public Optional<User> updateUser(User user) {
        try (EntityManagerHandler entityManagerHandler = new EntityManagerHandler()) {
            EntityManager entityManager = entityManagerHandler.getEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            User updatedUser = entityManager.merge(user);
            transaction.commit();
            return Optional.of(updatedUser);
        }
    }
}
