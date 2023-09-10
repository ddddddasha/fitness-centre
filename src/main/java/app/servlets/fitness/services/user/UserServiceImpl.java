package app.servlets.fitness.services.user;

import app.servlets.fitness.dto.user.UserRequest;
import app.servlets.fitness.dto.user.UserResponse;
import app.servlets.fitness.entities.User;
import app.servlets.fitness.mappers.UserMapper;
import app.servlets.fitness.repositories.user.UserRepository;
import app.servlets.fitness.services.password.PasswordHashing;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

import static app.servlets.fitness.entities.enums.Role.CLIENT;
import static app.servlets.fitness.util.Constants.*;
import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordHashing passwordHashing;

    @Override
    @Transactional
    public UserResponse create(UserRequest userRequest){
        User user = userMapper.mapUserRequestToUser(userRequest);
        user.setPassword(passwordHashing.hashPassword(userRequest.getPassword()));
        user.setRole(CLIENT);
        User savedUser = userRepository.save(user);
        return userMapper.mapUserToUserResponse(savedUser);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserResponse> read() {
        List<User> users = userRepository.findAll();
        return userMapper.mapUsersToUserResponses(users);
    }

    @Override
    @Transactional
    public UserResponse update(Long id, UserRequest userRequest) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(format(USER_SEARCH_EXCEPTION, id)));
        userMapper.updateUser(user, userRequest);
        user.setPassword(passwordHashing.hashPassword(userRequest.getPassword()));
        userRepository.save(user);
        return userMapper.mapUserToUserResponse(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponse findUserById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::mapUserToUserResponse)
                .orElseThrow(() -> new EntityNotFoundException(format(USER_SEARCH_EXCEPTION, id)));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findUserByIdForPurchase(Long id) {
        return userRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponse findUserByLogin(String login) {
        return userRepository.findUserByLogin(login)
                .map(userMapper::mapUserToUserResponse)
                .orElseThrow(() -> new EntityNotFoundException(format(USER_SEARCH_BY_LOGIN_EXCEPTION, login)));
    }
}
