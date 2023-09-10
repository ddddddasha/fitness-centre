package app.servlets.fitness.dto.user;

import app.servlets.fitness.entities.enums.Role;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

import static app.servlets.fitness.util.Constants.*;

@Data
@Builder
public class UserRequest {

    private Long userId;
    @NotBlank(message = INVALID_FIRST_NAME)
    private String firstName;
    @NotBlank(message = INVALID_LAST_NAME)
    private String lastName;
    @NotNull(message = INVALID_DATE_OF_BIRTH)
    private LocalDate dateBirthday;
    @NotBlank(message = INVALID_LOGIN)
    private String login;
    @NotBlank(message = INVALID_PASSWORD)
    private String password;
    @NotNull(message = INVALID_ROLE)
    private Role role;
}
