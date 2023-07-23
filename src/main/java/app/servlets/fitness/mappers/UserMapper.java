package app.servlets.fitness.mappers;

import app.servlets.fitness.dto.UserDto;
import app.servlets.fitness.entities.User;
import app.servlets.fitness.entities.enums.Role;

import java.sql.Date;
import java.time.LocalDate;

public class UserMapper {
    public User buildUser(String firstName, String lastName, LocalDate dateBirthday, String login, String password, Role role){
        return User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .dateBirthday(dateBirthday)
                .login(login)
                .password(password)
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

    public User toEntity(UserDto dto) {
        return User.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .dateBirthday(dto.getDateBirthday())
                .login(dto.getLogin())
                .password(dto.getPassword())
                .build();

    }

    public UserDto buildUserDto(String firstName, String lastName, LocalDate dateBirthday, String login, String password){
        return UserDto.builder()
                .firstName(firstName)
                .lastName(lastName)
                .dateBirthday(dateBirthday)
                .login(login)
                .password(password)
                .build();
    }
}
