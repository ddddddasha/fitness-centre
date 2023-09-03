package app.servlets.fitness.controllers.user;

import app.servlets.fitness.dto.user.UserRequest;
import app.servlets.fitness.dto.user.UserResponse;
import app.servlets.fitness.services.user.UserService;
import app.servlets.fitness.aspects.ExcludeLog;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @ExcludeLog
    @GetMapping(value = "/users")
    public List<UserResponse> read() {
        return userService.read();
    }

    @GetMapping(value = "/userById/{id}")
    public UserResponse findUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @ExcludeLog
    @GetMapping(value = "/userByLogin/{login}")
    public UserResponse findUserByLogin(@PathVariable String login) {
        return userService.findUserByLogin(login);
    }

    @PutMapping(value = "/user/{id}")
    public UserResponse update(@PathVariable Long id, @Valid @RequestBody UserRequest userRequest) {
        return userService.update(id, userRequest);
    }

    @DeleteMapping(value = "/user/{id}")
    public boolean delete(@PathVariable Long id) {
        return userService.delete(id);
    }
}
