package app.servlets.fitness.services.user;

import app.servlets.fitness.dto.user.UserRequest;
import app.servlets.fitness.dto.user.UserResponse;
import app.servlets.fitness.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserResponse create(UserRequest userRequest);

    List<UserResponse> read();

    UserResponse update(Long id, UserRequest userRequest);

    boolean delete(Long id);

    UserResponse findUserById(Long id);

    Optional<User> findUserByIdForPurchase(Long id);

    UserResponse findUserByLogin(String login);

}
