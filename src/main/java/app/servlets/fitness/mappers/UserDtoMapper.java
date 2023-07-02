package app.servlets.fitness.mappers;

import app.servlets.fitness.dto.UserDto;
import app.servlets.fitness.entities.User;

public class UserDtoMapper {

    public User toEntity(UserDto dto) {
        return User.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .age(dto.getAge())
                .login(dto.getLogin())
                .password(dto.getPassword())
                .build();

    }

    public UserDto buildUserDto(String firstName, String lastName, int age, String login, String password){
        return UserDto.builder()
                .firstName(firstName)
                .lastName(lastName)
                .age(age)
                .login(login)
                .password(password)
                .build();
    }
}
