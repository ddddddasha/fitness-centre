package app.servlets.fitness.services;

import app.servlets.fitness.entities.User;
import app.servlets.fitness.entities.enums.Role;
import app.servlets.fitness.exseptions.UserSearchException;
import app.servlets.fitness.repositories.UserRepository;

import app.servlets.fitness.util.PasswordHashing;
import lombok.Builder;

import java.util.List;
import java.util.Optional;

import static app.servlets.fitness.util.Constants.*;
import static app.servlets.fitness.util.Constants.USER_EDIT_EXCEPTION;

@Builder
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final PasswordHashing passwordHashing = new PasswordHashing();

    @Override
    public User createUser(User user) {
        return userRepository.createUser(
                new User(user.getId(), user.getFirstName(), user.getLastName(),
                        user.getDateBirthday(), user.getLogin(), passwordHashing.hashPassword(user.getPassword()),
                        Role.CLIENT)
        );
    }

    @Override
    public Optional<User> getByLogin(String login) {
        return userRepository.getByLogin(login);
    }

    @Override
    public List<User> readUsers() {
        return userRepository.readUsers();
    }

    @Override
    public User deleteById(long id) throws UserSearchException {
        return userRepository.deleteById(id)
                .orElseThrow(() -> new UserSearchException(USER_DELETE_EXCEPTION));
    }

    @Override
    public User getById(long id) throws UserSearchException {
        return userRepository.getById(id)
                .orElseThrow(() -> new UserSearchException(USER_SEARCH_EXCEPTION));
    }

    @Override
    public User updateUser(User user) throws UserSearchException {
        return userRepository.updateUser(user)
                .orElseThrow(() -> new UserSearchException(USER_EDIT_EXCEPTION));
    }

    @Override
    public User logIn(String login, String password) {
        return userRepository.getByLogin(login)
                .filter(user -> passwordHashing.verifyPassword(password, user.getPassword()))
                .orElse(null);
    }
}
