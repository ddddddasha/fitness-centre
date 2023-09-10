package app.servlets.fitness.arguments.user;

import app.servlets.fitness.entities.User;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.time.LocalDate;
import java.util.stream.Stream;

import static app.servlets.fitness.entities.enums.Role.CLIENT;

public class UserInvalidArguments implements ArgumentsProvider {

    public static final User USER = User.builder()
            .id(123L)
            .firstName("Taras")
            .lastName("Potapenko")
            .dateBirthday(LocalDate.parse("2003-07-11"))
            .login("potapenko@gmail.com")
            .password("client")
            .role(CLIENT)
            .build();

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of(USER)
        );
    }
}
