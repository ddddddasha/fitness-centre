package app.servlets.fitness.dto.user;

import app.servlets.fitness.dto.purchase.PurchaseResponse;
import app.servlets.fitness.entities.enums.Role;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

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
    private List<PurchaseResponse> purchases;
}
