package app.servlets.fitness.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class UserDto {
    private String firstName;
    private String lastName;
    private LocalDate dateBirthday;
    private String login;
    private String password;
}
