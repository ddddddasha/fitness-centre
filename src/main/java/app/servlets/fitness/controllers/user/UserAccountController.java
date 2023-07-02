package app.servlets.fitness.controllers.user;

import app.servlets.fitness.entities.User;
import app.servlets.fitness.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static app.servlets.fitness.util.Constants.*;

@WebServlet(urlPatterns = "/user/account")
public class UserAccountController extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = (UserService) getServletContext().getAttribute(USER_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String login = (String) session.getAttribute(LOGIN);
        User user = userService.getByLogin(login);
        req.setAttribute(USER, user);
        req.getRequestDispatcher(CLIENT_HOME_PAGE).forward(req, resp);
    }
}
