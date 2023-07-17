package app.servlets.fitness.mappers;

import app.servlets.fitness.dto.UserDto;
import app.servlets.fitness.entities.User;

import java.time.LocalDate;

public class UserDtoMapper {

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
