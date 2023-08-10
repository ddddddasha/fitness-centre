package app.servlets.fitness.services;

import app.servlets.fitness.dto.UserDto;
import app.servlets.fitness.entities.User;
import app.servlets.fitness.exseptions.UserSearchException;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user);
    UserDto getByLogin(String login) throws UserSearchException;
    List<User> readUsers();
    User deleteById(long id) throws UserSearchException;
    User getById(long id) throws UserSearchException;
    User updateUser(User user) throws UserSearchException;
    UserDto logIn(String login, String password);
}
