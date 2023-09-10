package app.servlets.fitness.arguments.user;

import app.servlets.fitness.dto.user.UserResponse;
import app.servlets.fitness.entities.User;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.time.LocalDate;
import java.util.stream.Stream;

import static app.servlets.fitness.entities.enums.Role.ADMIN;


public class UserGetArguments implements ArgumentsProvider {

    public static final User USER = User.builder()
            .id(1L)
            .firstName("Dasha")
            .lastName("Zhelobkovich")
            .dateBirthday(LocalDate.parse("2003-07-11"))
            .login("dzhelobkovich@gmail.com")
            .password("admin")
            .role(ADMIN)
            .build();
    public static final UserResponse USER_RESPONSE = UserResponse.builder()
            .id(1L)
            .firstName("Dasha")
            .lastName("Zhelobkovich")
            .dateBirthday(LocalDate.parse("2003-07-11"))
            .login("dzhelobkovich@gmail.com")
            .password("admin")
            .role(ADMIN)
            .build();

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of(USER, USER_RESPONSE)
        );
    }
}
