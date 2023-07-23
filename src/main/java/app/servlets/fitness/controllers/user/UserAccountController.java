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

@WebServlet(urlPatterns = "/user/account", loadOnStartup = 1)
public class UserAccountController extends HttpServlet {
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String login = (String) session.getAttribute(LOGIN);
        User user = userService.getByLogin(login).get();
        req.setAttribute(USER, user);
        req.getRequestDispatcher(CLIENT_HOME_PAGE).forward(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = (UserService) config.getServletContext().getAttribute(USER_SERVICE);
    }
}
