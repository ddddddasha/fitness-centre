package app.servlets.fitness.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private String firstName;
    private String lastName;
    private int age;
    private String login;
    private String password;
}
