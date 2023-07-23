package app.servlets.fitness.controllers.user;

import app.servlets.fitness.entities.User;
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

@WebServlet(urlPatterns = "/user/edit", loadOnStartup = 1)
public class EditUserController extends HttpServlet {
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter(ID);

        User user = userService.getById(Long.parseLong(userId));
        if (user != null) {
            req.setAttribute(USER, user);
            req.getRequestDispatcher(EDIT_USER_PAGE).forward(req, resp);
        } else {
            resp.sendRedirect(INDEX_PAGE);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UserMapper userMapper = new UserMapper();
        String id = req.getParameter(ID);
        String firstName = req.getParameter(FIRST_NAME);
        String lastName = req.getParameter(LAST_NAME);
        LocalDate dateBirthday = LocalDate.parse((req.getParameter(AGE)));
        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);
        User user = userMapper.buildUserForUserPage(Long.parseLong(id), firstName, lastName, dateBirthday, login, password);
        userService.updateUser(user);
        resp.sendRedirect(ALL_USERS_PAGE);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = (UserService) config.getServletContext().getAttribute(USER_SERVICE);
    }
}
