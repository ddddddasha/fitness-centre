package app.servlets.fitness.services;

import app.servlets.fitness.entities.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getByLogin(String login);
    List<User> readUsers();
    boolean deleteById(long id);
    User getById(long id);
    User updateUser(User user);
    User logIn(String login, String password);
}
