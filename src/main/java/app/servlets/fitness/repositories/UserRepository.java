package app.servlets.fitness.repositories;

import app.servlets.fitness.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User createUser(User user);

    List<User> readUsers();

    Optional<User> getByLogin(String login);

    Optional<User> deleteById(long id);

    Optional<User> getById(long id);

    Optional<User> updateUser(User user);

}
