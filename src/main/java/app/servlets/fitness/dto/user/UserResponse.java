package app.servlets.fitness.dto.user;

import app.servlets.fitness.dto.purchase.PurchaseResponse;
import app.servlets.fitness.entities.enums.Role;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

@Data
@Builder
public class UserResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateBirthday;
    private String login;
    private String password;
    private Role role;
    @JsonInclude(NON_EMPTY)
    private List<PurchaseResponse> purchases;
}
