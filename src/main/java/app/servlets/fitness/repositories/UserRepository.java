package app.servlets.fitness.repositories;

import app.servlets.fitness.entities.User;

import java.util.List;

public interface UserRepository {
    User createUser(User user);

    List<User> readUsers();

    User getByLogin(String login);

    boolean deleteById(String id);

    User getById(String id);

    User updateUser(User user);

    boolean isIdExistsInDatabase(String id);

}
