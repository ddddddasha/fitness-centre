package app.servlets.fitness.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String id;
    private String firstName;
    private String lastName;
    private int age;
    private String login;
    private String password;
    private String role;
}
