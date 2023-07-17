package app.servlets.fitness.repositories;

import app.servlets.fitness.entities.User;

import java.util.List;

public interface UserRepository {
    User createUser(User user);

    List<User> readUsers();

    User getByLogin(String login);

    boolean deleteById(long id);

    User getById(long id);

    User updateUser(User user);

}
