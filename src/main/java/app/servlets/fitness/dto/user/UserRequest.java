package app.servlets.fitness.dto.user;

import app.servlets.fitness.dto.purchase.PurchaseResponse;
import app.servlets.fitness.entities.enums.Role;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class UserRequest {

    private Long userId;

    @NotBlank(message = "First name cannot be blank")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    private String lastName;

    @NotNull(message = "Date of birth cannot be null")
    private LocalDate dateBirthday;

    @NotBlank(message = "Login cannot be blank")
    private String login;

    @NotBlank(message = "Password cannot be blank")
    private String password;

    @NotNull(message = "Role cannot be null")
    private Role role;

}
