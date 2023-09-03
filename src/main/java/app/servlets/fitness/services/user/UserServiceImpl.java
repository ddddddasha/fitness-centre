package app.servlets.fitness.services.user;

import app.servlets.fitness.dto.user.UserRequest;
import app.servlets.fitness.dto.user.UserResponse;
import app.servlets.fitness.entities.User;
import app.servlets.fitness.exseptions.user.UserNotFoundException;
import app.servlets.fitness.mappers.PurchaseMapper;
import app.servlets.fitness.mappers.UserMapper;
import app.servlets.fitness.repositories.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static app.servlets.fitness.util.Constants.*;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse create(UserRequest userRequest){
        User user = userMapper.mapUserRequestToUser(userRequest);
        userRepository.save(user);
        return userMapper.mapUserToUserResponse(user);
    }

    @Override
    public List<UserResponse> read() {
        List<User> users = userRepository.findAll();
        return userMapper.mapUsersToUserResponses(users);
    }

    @Override
    public UserResponse update(Long id, UserRequest userRequest) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(USER_SEARCH_EXCEPTION + id));
        userMapper.updateUser(user, userRequest);
        return userMapper.mapUserToUserResponse(userRepository.save(user));
    }

    @Override
    public boolean delete(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        optionalUser.ifPresent(userRepository::delete);
        return optionalUser.isPresent();
    }

    @Override
    public UserResponse findUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(USER_SEARCH_EXCEPTION + id));
        return userMapper.mapUserToUserResponse(user);
    }

    @Override
    public Optional<User> findUserByIdForPurchase(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public UserResponse findUserByLogin(String login) {
        User user = userRepository.findUserByLogin(login)
                .orElseThrow(() -> new UserNotFoundException(USER_SEARCH_BY_LOGIN_EXCEPTION + login));
        return userMapper.mapUserToUserResponse(user);
    }
}
