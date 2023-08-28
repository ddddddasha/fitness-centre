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
    private final PurchaseMapper purchaseMapper;

    @Override
    public UserResponse create(UserRequest userRequest){
        User user = userMapper.buildUser(userRequest);
        userRepository.save(user);
        return userMapper.buildUserResponse(user, purchaseMapper);
    }

    @Override
    public List<UserResponse> read() {
        List<User> users = userRepository.findAll();
        return userMapper.buildUsersResponses(users, purchaseMapper);
    }

    @Override
    public UserResponse update(Long id, UserRequest userRequest) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.map(user -> userMapper.updateUser(user, userRequest))
                .map(userRepository::save)
                .map(user -> userMapper.buildUserResponse(user, purchaseMapper))
                .orElseThrow(() -> new UserNotFoundException(USER_SEARCH_EXCEPTION + id));
    }

    @Override
    public boolean delete(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        optionalUser.ifPresent(userRepository::delete);
        return optionalUser.isPresent();
    }

    @Override
    public UserResponse findUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.map(user -> userMapper.buildUserResponse(user, purchaseMapper))
                .orElseThrow(() -> new UserNotFoundException(USER_SEARCH_EXCEPTION + id));
    }

    @Override
    public Optional<User> findUserByIdForPurchase(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public UserResponse findUserByLogin(String login) {
        Optional<User> optionalUser = userRepository.findUserByLogin(login);
        return optionalUser.map(user -> userMapper.buildUserResponse(user, purchaseMapper))
                .orElseThrow(() -> new UserNotFoundException(USER_SEARCH_BY_LOGIN_EXCEPTION + login));
    }
}
