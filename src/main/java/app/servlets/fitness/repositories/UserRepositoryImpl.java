package app.servlets.fitness.repositories;

import app.servlets.fitness.dto.UserDto;
import app.servlets.fitness.entities.User;
import app.servlets.fitness.mappers.UserMapper;
import app.servlets.fitness.util.EntityManagerHandler;
import lombok.Builder;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

import static app.servlets.fitness.util.Constants.*;

@Builder
public class UserRepositoryImpl implements UserRepository {
    private final UserMapper userMapper = UserMapper.getInstance();

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

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
            Root<User> userRoot = criteriaQuery.from(User.class);
            criteriaQuery.select(userRoot);

            Query query = entityManager.createQuery(criteriaQuery);
            return query.getResultList();
        }
    }

    @Override
    public Optional<UserDto> getByLogin(String login) {
        try (EntityManagerHandler entityManagerHandler = new EntityManagerHandler()) {
            EntityManager entityManager = entityManagerHandler.getEntityManager();
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<User> userCriteriaQuery = criteriaBuilder.createQuery(User.class);
            Root<User> root = userCriteriaQuery.from(User.class);

            userCriteriaQuery.select(root)
                    .where(criteriaBuilder.equal(root.get(LOGIN), login));

            User user = entityManager.createQuery(userCriteriaQuery).getSingleResult();

            UserDto userDto = userMapper.mapToDto(user);
            return Optional.ofNullable(userDto);
        } catch (NoResultException e) {
            return Optional.empty();
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
            User updatedUser = entityManager.find(User.class, user.getId());
            updatedUser.setFirstName(user.getFirstName());
            updatedUser.setLastName(user.getLastName());
            updatedUser.setDateBirthday(user.getDateBirthday());
            updatedUser.setLogin(user.getLogin());
            updatedUser.setPassword(user.getPassword());
            updatedUser.setRole(user.getRole());
            transaction.commit();
            return Optional.of(updatedUser);
        }
    }
}
