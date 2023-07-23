package app.servlets.fitness.entities;

import app.servlets.fitness.entities.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private long id;
    private String firstName;
    private String lastName;
    private LocalDate dateBirthday;
    private String login;
    private String password;
    private Role role;
}
