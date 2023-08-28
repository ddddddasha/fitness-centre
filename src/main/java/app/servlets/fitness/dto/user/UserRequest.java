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

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotNull
    private LocalDate dateBirthday;

    @NotBlank
    private String login;

    @NotBlank
    private String password;

    @NotNull
    private Role role;

    private List<PurchaseResponse> purchases;
}
