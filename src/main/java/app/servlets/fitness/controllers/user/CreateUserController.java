package app.servlets.fitness.controllers.user;

import app.servlets.fitness.creators.ServiceCreator;
import app.servlets.fitness.dto.UserDto;
import app.servlets.fitness.mappers.UserMapper;
import app.servlets.fitness.services.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

import static app.servlets.fitness.util.Constants.*;

@WebServlet(urlPatterns = "/user/create", loadOnStartup = 0)
public class CreateUserController extends HttpServlet {
    private UserService userService;
    private final UserMapper userMapper = UserMapper.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDto userDto = userMapper.buildUserDto(req.getParameter(FIRST_NAME),
                req.getParameter(LAST_NAME),
                LocalDate.parse(req.getParameter(AGE)),
                req.getParameter(LOGIN),
                req.getParameter(PASSWORD)
        );
        userService.createUser(userMapper.toEntity(userDto));
        req.getRequestDispatcher(SIGN_IN_PAGE).forward(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServiceCreator serviceCreator = new ServiceCreator();
        userService = serviceCreator.buildUserService();
        config.getServletContext().setAttribute(USER_SERVICE, userService);
    }
}
