package app.servlets.fitness.arguments.user;

import app.servlets.fitness.dto.user.UserRequest;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.time.LocalDate;
import java.util.stream.Stream;

import static app.servlets.fitness.entities.enums.Role.ADMIN;

public class UserInvalidUpdateArguments implements ArgumentsProvider {

    public static final Long NON_EXISTENT_USER_ID  = 99L;
    public static final UserRequest USER_REQUEST = UserRequest.builder()
            .firstName("Lisa")
            .lastName("Alekseeva")
            .dateBirthday(LocalDate.parse("2002-01-07"))
            .login("alekseeva@gmail.com")
            .password("test")
            .role(ADMIN)
            .build();

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of(NON_EXISTENT_USER_ID, USER_REQUEST)
        );
    }
}
