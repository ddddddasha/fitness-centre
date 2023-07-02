package app.servlets.fitness.services;

import app.servlets.fitness.entities.User;
import app.servlets.fitness.entities.enums.Role;
import app.servlets.fitness.repositories.UserRepository;
import app.servlets.fitness.repositories.UserRepositoryImpl;
import app.servlets.fitness.util.PasswordHashing;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserServiceImpl implements UserService{
    private final UserRepository userRepository = new UserRepositoryImpl();
    private final PasswordHashing passwordHashing = new PasswordHashing();

    @Override
    public User createUser(User user) {
        return userRepository.createUser(
                new User(generateUniqueId(), user.getFirstName(), user.getLastName(),
                        user.getAge(), user.getLogin(), passwordHashing.hashPassword(user.getPassword()), Role.CLIENT.name())
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
    public boolean deleteById(String id) {
        return userRepository.deleteById(id);
    }

    @Override
    public User getById(String id) {
        return userRepository.getById(id);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.updateUser(user);
    }

    @Override
    public boolean isIdExistsInDatabase(String id) {
        return userRepository.isIdExistsInDatabase(id);
    }

    @Override
    public User logIn(String login, String password) {
        return Optional.ofNullable(userRepository.getByLogin(login))
                .filter(user -> passwordHashing.verifyPassword(password, user.getPassword()))
                .orElse(null);
    }

    private String generateUniqueId() {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
        while (isIdExistsInDatabase(id)) {
            uuid = UUID.randomUUID();
            id = uuid.toString();
        }
        return id;
    }
}
