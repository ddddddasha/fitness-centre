package app.servlets.fitness.controllers.user;

import app.servlets.fitness.entities.User;
import app.servlets.fitness.services.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static app.servlets.fitness.util.Constants.*;

@WebServlet(urlPatterns = "/login", loadOnStartup = 1)
public class LoginController extends HttpServlet {
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(SIGN_IN_PAGE).forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);
        User user = userService.logIn(login, password);

        HttpSession session = req.getSession();

        if (user != null) {
            session.setAttribute(LOGIN, user.getLogin());
            session.setAttribute(ROLE, user.getRole());
            req.getRequestDispatcher(INDEX_PAGE).forward(req, resp);
        } else {
            req.setAttribute(ERROR_MESSAGE, ERROR_LOGIN_MESSAGE);
            req.getRequestDispatcher(SIGN_IN_PAGE).forward(req, resp);
        }
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = (UserService) config.getServletContext().getAttribute(USER_SERVICE);
    }
}
