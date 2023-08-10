package app.servlets.fitness.mappers;

import app.servlets.fitness.dto.UserDto;
import app.servlets.fitness.entities.User;
import app.servlets.fitness.entities.enums.Role;
import java.time.LocalDate;

public class UserMapper {

    private static UserMapper instance;
    private final PurchaseMapper purchaseMapper = PurchaseMapper.getInstance();

    private UserMapper() {
    }

    public static UserMapper getInstance() {
        if (instance == null) {
            instance = new UserMapper();
        }
        return instance;
    }
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

    public UserDto mapToDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .dateBirthday(user.getDateBirthday())
                .login(user.getLogin())
                .password(user.getPassword())
                .role(user.getRole())
                .purchases(purchaseMapper.mapToDtoList(user.getPurchases()))
                .build();
    }
}
