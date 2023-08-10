package app.servlets.fitness.controllers.user;

import app.servlets.fitness.entities.User;
import app.servlets.fitness.entities.enums.Role;
import app.servlets.fitness.exseptions.UserSearchException;
import app.servlets.fitness.mappers.UserMapper;
import app.servlets.fitness.services.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

import static app.servlets.fitness.util.Constants.*;

@WebServlet(urlPatterns = "/user/edit", loadOnStartup = 1)
public class EditUserController extends HttpServlet {
    private UserService userService;
    private final UserMapper userMapper = UserMapper.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter(ID);
        try {
            User user = userService.getById(Long.parseLong(userId));
            req.setAttribute(USER, user);
            req.getRequestDispatcher(EDIT_USER_PAGE).forward(req, resp);
        } catch (UserSearchException e){
            req.setAttribute(ERROR_MESSAGE, e.getMessage());
            req.getRequestDispatcher(EDIT_USER_EXCEPTION_PAGE).forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String id = req.getParameter(ID);
        String firstName = req.getParameter(FIRST_NAME);
        String lastName = req.getParameter(LAST_NAME);
        LocalDate dateBirthday = LocalDate.parse((req.getParameter(AGE)));
        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);
        User user = userMapper.buildUserForUserPage(Long.parseLong(id), firstName, lastName, dateBirthday, login, password);
        try {
            userService.updateUser(user);
        } catch (UserSearchException e) {
            req.setAttribute(ERROR_MESSAGE, e.getMessage());
            req.getRequestDispatcher(EDIT_USER_EXCEPTION_PAGE).forward(req, resp);
        }
        resp.sendRedirect(ALL_USERS_PAGE);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = (UserService) config.getServletContext().getAttribute(USER_SERVICE);
    }
}
