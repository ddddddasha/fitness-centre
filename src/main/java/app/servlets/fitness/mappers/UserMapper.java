package app.servlets.fitness.mappers;

import app.servlets.fitness.dto.user.UserRequest;
import app.servlets.fitness.dto.user.UserResponse;
import app.servlets.fitness.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.List;

import static app.servlets.fitness.util.Constants.PASSWORD;
import static app.servlets.fitness.util.Constants.ROLE;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Component
@Mapper(uses = PurchaseMapper.class, componentModel = "spring", nullValuePropertyMappingStrategy = IGNORE)
public interface UserMapper {

    @Mapping(target = PASSWORD, ignore = true)
    @Mapping(target = ROLE, ignore = true)
    User mapUserRequestToUser(UserRequest userRequest);
    @Named("mapUserToUserResponse")
    UserResponse mapUserToUserResponse(User user);
    List<UserResponse> mapUsersToUserResponses(List<User> users);
    @Named("mapToUserResponseForPurchase")
    @Mapping(target = "purchases", ignore = true)
    UserResponse mapToUserResponseForPurchase(User user);
    void updateUser(@MappingTarget User user, UserRequest userRequest);
}