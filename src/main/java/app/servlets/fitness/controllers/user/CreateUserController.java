package app.servlets.fitness.controllers.user;

import app.servlets.fitness.dto.UserDto;
import app.servlets.fitness.mappers.UserDtoMapper;
import app.servlets.fitness.services.UserService;
import app.servlets.fitness.services.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static app.servlets.fitness.util.Constants.*;

@WebServlet(urlPatterns = "/user/create")
public class CreateUserController extends HttpServlet {
    private UserDtoMapper userDtoMapper;
    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = (UserService) getServletContext().getAttribute(USER_SERVICE);
        if (userService == null) {
            userService = new UserServiceImpl();
            getServletContext().setAttribute(USER_SERVICE, userService);
        }

        userDtoMapper = (UserDtoMapper) getServletContext().getAttribute(USER_DTO_MAPPER);
        if (userDtoMapper == null) {
            userDtoMapper = new UserDtoMapper();
            getServletContext().setAttribute(USER_DTO_MAPPER, userDtoMapper);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDto userDto = userDtoMapper.buildUserDto(req.getParameter(FIRST_NAME),
                req.getParameter(LAST_NAME),
                Integer.parseInt(req.getParameter(AGE)),
                req.getParameter(LOGIN),
                req.getParameter(PASSWORD)
        );
        userService.createUser(userDtoMapper.toEntity(userDto));
        req.getRequestDispatcher(SIGN_IN_PAGE).forward(req, resp);
    }
}
