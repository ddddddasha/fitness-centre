package app.servlets.fitness.services;

import app.servlets.fitness.entities.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getByLogin(String login);
    List<User> readUsers();
    boolean deleteById(String id);
    User getById(String id);
    User updateUser(User user);
    boolean isIdExistsInDatabase(String id);
    User logIn(String login, String password);
}
