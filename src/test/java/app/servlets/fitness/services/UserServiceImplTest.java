package app.servlets.fitness.services;

import app.servlets.fitness.arguments.user.*;
import app.servlets.fitness.dto.user.UserRequest;
import app.servlets.fitness.dto.user.UserResponse;
import app.servlets.fitness.entities.User;
import app.servlets.fitness.mappers.UserMapper;
import app.servlets.fitness.repositories.user.UserRepository;
import app.servlets.fitness.services.password.PasswordHashing;
import app.servlets.fitness.services.user.UserService;
import app.servlets.fitness.services.user.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
@DisplayName("Testing UserService")
public class UserServiceImplTest {

    private UserService userService;
    @Mock
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordHashing passwordHashing;

    @BeforeEach
    void init() {
        userService = new UserServiceImpl(userRepository, userMapper, passwordHashing);
    }

    @ParameterizedTest
    @DisplayName("save user")
    @ArgumentsSource(UserSaveArguments.class)
    void saveUserTest(UserRequest userRequest, User user, UserResponse expectedUserResponse) {
        when(userRepository.save(any(User.class))).thenReturn(user);
        UserResponse actualUserResponse = userService.create(userRequest);
        assertEquals(expectedUserResponse, actualUserResponse);
    }

    @ParameterizedTest
    @DisplayName("read users")
    @ArgumentsSource(UserGetArguments.class)
    void readUsersTest(User user, UserResponse userResponse) {
        when(userRepository.findAll()).thenReturn(List.of(user));
        List<UserResponse> retrievedUsers = userService.read();
        assertEquals(Collections.singletonList(userResponse), retrievedUsers);
    }

    @ParameterizedTest
    @DisplayName("update user")
    @ArgumentsSource(UserUpdateArguments.class)
    void updateTest(UserRequest userRequest, User user, UserResponse expectedUserResponse) {
        when(userRepository.findById(any(Long.class))).thenReturn(Optional.of(user));
        when(userRepository.save(any(User.class))).thenReturn(user);
        UserResponse actualUserResponse = userService.update(user.getId(), userRequest);
        assertEquals(expectedUserResponse, actualUserResponse);
    }

    @ParameterizedTest
    @DisplayName("find user by id")
    @ArgumentsSource(UserGetArguments.class)
    void findUserByIdTest(User user, UserResponse expectedUserResponse) {
        when(userRepository.findById(any(Long.class))).thenReturn(Optional.of(user));
        UserResponse actualUserResponse = userService.findUserById(user.getId());
        assertEquals(expectedUserResponse, actualUserResponse);
    }

    @ParameterizedTest
    @DisplayName("find user by login")
    @ArgumentsSource(UserGetArguments.class)
    void findUserByLoginTest(User user, UserResponse expectedUserResponse) {
        when(userRepository.findUserByLogin(any(String.class))).thenReturn(Optional.of(user));
        UserResponse actualUserResponse = userService.findUserByLogin(user.getLogin());
        assertEquals(expectedUserResponse, actualUserResponse);
    }

    @Test
    @DisplayName("delete user")
    public void deletePersonTest() {
        userService.delete(12L);
        verify(userRepository).deleteById(12L);
    }

    @ParameterizedTest
    @DisplayName("update user for exception")
    @ArgumentsSource(UserInvalidUpdateArguments.class)
    void updateExpectedException(Long id, UserRequest userRequest) {
        when(userRepository.findById(any(Long.class))).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> userService.update(id, userRequest));
        verify(userRepository, never()).save(any());
    }

    @ParameterizedTest
    @DisplayName("find user by id for exception")
    @ArgumentsSource(UserInvalidArguments.class)
    void findUserByIdExpectedException(User user) {
        when(userRepository.findById(any(Long.class))).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> userService.findUserById(user.getId()));
    }

    @ParameterizedTest
    @DisplayName("find user by login for exception")
    @ArgumentsSource(UserInvalidArguments.class)
    void getUserByLoginExpectedException(User user) {
        when(userRepository.findUserByLogin(any(String.class))).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> userService.findUserByLogin(user.getLogin()));
    }
}
