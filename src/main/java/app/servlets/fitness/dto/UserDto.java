package app.servlets.fitness.dto;

import app.servlets.fitness.entities.Purchase;
import app.servlets.fitness.entities.enums.Role;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class UserDto {
    private long id;
    private String firstName;
    private String lastName;
    private LocalDate dateBirthday;
    private String login;
    private String password;
    private Role role;
    private List<PurchaseDto> purchases;
}
