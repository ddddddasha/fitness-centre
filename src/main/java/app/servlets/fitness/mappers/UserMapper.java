package app.servlets.fitness.mappers;

import app.servlets.fitness.dto.user.UserRequest;
import app.servlets.fitness.dto.user.UserResponse;
import app.servlets.fitness.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Component
@Mapper(uses = PurchaseMapper.class, componentModel = "spring", nullValuePropertyMappingStrategy = IGNORE)
public interface UserMapper {

    //@Mapping(target = "password", source = "password", qualifiedByName = "hashPassword")
    User mapUserRequestToUser(UserRequest userRequest);

    @Named("mapUserToUserResponse")
    UserResponse mapUserToUserResponse(User user);

    List<UserResponse> mapUsersToUserResponses(List<User> users);

    UserResponse mapUserToUserResponseWithoutPurchases(User user);

    User updateUser(@MappingTarget User user, UserRequest userRequest);
}