package app.servlets.fitness.mappers;

import app.servlets.fitness.entities.User;
import app.servlets.fitness.entities.enums.Role;

import java.time.LocalDate;

public class UserMapper {
    public User buildUser(long id, String firstName, String lastName, LocalDate dateBirthday, String login, Role role){
        return User.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .dateBirthday(dateBirthday)
                .login(login)
                .role(role)
                .build();
    }

    public User buildUserForSignIn(String firstName, String lastName, LocalDate dateBirthday, String login, String password, Role role){
        return User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .dateBirthday(dateBirthday)
                .login(login)
                .password(password)
                .role(role)
                .build();
    }

    public User buildUserForUserPage(long id, String firstName, String lastName, LocalDate dateBirthday, String login, String password){
        return User.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .dateBirthday(dateBirthday)
                .login(login)
                .password(password)
                .build();
    }
}
