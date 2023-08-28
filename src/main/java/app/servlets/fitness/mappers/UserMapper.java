package app.servlets.fitness.mappers;

import app.servlets.fitness.dto.user.UserRequest;
import app.servlets.fitness.dto.user.UserResponse;
import app.servlets.fitness.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserMapper {

    public User buildUser(UserRequest userRequest){
        return User.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .dateBirthday(userRequest.getDateBirthday())
                .login(userRequest.getLogin())
                .password(userRequest.getPassword())
                .role(userRequest.getRole())
                .build();
    }

    public UserResponse buildUserResponse(User user, PurchaseMapper purchaseMapper){
        UserResponse userResponse = UserResponse.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .dateBirthday(user.getDateBirthday())
                .login(user.getLogin())
                .password(user.getPassword())
                .role(user.getRole())
                .build();

        if(user.getPurchases() != null){
            userResponse.setPurchases(purchaseMapper.buildPurchasesResponseForUser(user.getPurchases()));
        }
        return userResponse;
    }

    public UserResponse buildUserResponseWithoutPurchases(User user){

        return UserResponse.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .dateBirthday(user.getDateBirthday())
                .login(user.getLogin())
                .password(user.getPassword())
                .role(user.getRole())
                .build();

    }

    public List<UserResponse> buildUsersResponses(List<User> users, PurchaseMapper purchaseMapper) {
        return users.stream()
                .map(user -> buildUserResponse(user, purchaseMapper))
                .collect(Collectors.toList());
    }

    public User updateUser(User user, UserRequest userRequest) {
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setDateBirthday(userRequest.getDateBirthday());
        user.setLogin(userRequest.getLogin());
        user.setPassword(userRequest.getPassword());
        user.setRole(userRequest.getRole());
        return user;
    }
}
