package app.servlets.fitness.controllers.user;

import app.servlets.fitness.dto.user.UserRequest;
import app.servlets.fitness.dto.user.UserResponse;
import app.servlets.fitness.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping(value = "/user")
    public UserResponse create(@Valid @RequestBody UserRequest userRequest) {
        return userService.create(userRequest);
    }

    @GetMapping(value = "/users")
    public List<UserResponse> read() {
        return userService.read();
    }

    @GetMapping(value = "/userById/{id}")
    public UserResponse findUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @GetMapping(value = "/userByLogin/{login}")
    public UserResponse findUserByLogin(@PathVariable String login) {
        return userService.findUserByLogin(login);
    }

    @PutMapping(value = "/user/{id}")
    public UserResponse update(@PathVariable @Min(1) Long id, @Valid @RequestBody UserRequest userRequest) {
        return userService.update(id, userRequest);
    }

    @DeleteMapping(value = "/user/{id}")
    public boolean delete(@PathVariable @Min(1) Long id) {
        return userService.delete(id);
    }
}
