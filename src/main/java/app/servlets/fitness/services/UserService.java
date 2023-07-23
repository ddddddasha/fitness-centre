package app.servlets.fitness.services;

import app.servlets.fitness.entities.User;
import app.servlets.fitness.exseptions.UserSearchException;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user);
    Optional<User> getByLogin(String login);
    List<User> readUsers();
    User deleteById(long id) throws UserSearchException;
    User getById(long id) throws UserSearchException;
    User updateUser(User user) throws UserSearchException;
    User logIn(String login, String password);
}
