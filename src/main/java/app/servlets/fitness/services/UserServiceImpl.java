package app.servlets.fitness.services;

import app.servlets.fitness.entities.User;
import app.servlets.fitness.entities.enums.Role;
import app.servlets.fitness.repositories.UserRepository;

import app.servlets.fitness.util.PasswordHashing;
import lombok.Builder;

import java.util.List;
import java.util.Optional;

@Builder
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final PasswordHashing passwordHashing = new PasswordHashing();

    @Override
    public User createUser(User user) {
        return userRepository.createUser(
                new User(user.getId(), user.getFirstName(), user.getLastName(),
                        user.getDateBirthday(), user.getLogin(), passwordHashing.hashPassword(user.getPassword()), Role.CLIENT)
        );
    }

    @Override
    public User getByLogin(String login) {
        return userRepository.getByLogin(login);
    }

    @Override
    public List<User> readUsers() {
        return userRepository.readUsers();
    }

    @Override
    public boolean deleteById(long id) {
        return userRepository.deleteById(id);
    }

    @Override
    public User getById(long id) {
        return userRepository.getById(id);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.updateUser(user);
    }

    @Override
    public User logIn(String login, String password) {
        return Optional.ofNullable(userRepository.getByLogin(login))
                .filter(user -> passwordHashing.verifyPassword(password, user.getPassword()))
                .orElse(null);
    }
}
