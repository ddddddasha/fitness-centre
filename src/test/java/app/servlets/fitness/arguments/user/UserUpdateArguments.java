package app.servlets.fitness.arguments.user;

import app.servlets.fitness.dto.user.UserRequest;
import app.servlets.fitness.dto.user.UserResponse;
import app.servlets.fitness.entities.User;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.time.LocalDate;
import java.util.stream.Stream;

import static app.servlets.fitness.entities.enums.Role.ADMIN;
import static app.servlets.fitness.entities.enums.Role.CLIENT;

public class UserUpdateArguments implements ArgumentsProvider {

    public static final User USER = User.builder()
            .id(3L)
            .firstName("Taras")
            .lastName("Potapenko")
            .dateBirthday(LocalDate.parse("2000-01-07"))
            .login("ponapenkotaras@gmail.com")
            .password("123test123")
            .role(CLIENT)
            .build();
    public static final UserRequest USER_REQUEST = UserRequest.builder()
            .firstName("Lisa")
            .lastName("Alekseeva")
            .dateBirthday(LocalDate.parse("2002-01-07"))
            .login("alekseeva@gmail.com")
            .password("test")
            .role(ADMIN)
            .build();
    public static final UserResponse USER_RESPONSE = UserResponse.builder()
            .id(3L)
            .firstName("Lisa")
            .lastName("Alekseeva")
            .dateBirthday(LocalDate.parse("2002-01-07"))
            .login("alekseeva@gmail.com")
            .password("test")
            .role(ADMIN)
            .build();

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext){
        return Stream.of(
                Arguments.of(USER_REQUEST, USER, USER_RESPONSE)
        );
    }
}