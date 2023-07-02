package app.servlets.fitness.controllers.user;

import app.servlets.fitness.entities.User;
import app.servlets.fitness.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static app.servlets.fitness.util.Constants.*;

@WebServlet(urlPatterns = "/admin/users")
public class ReadUserController extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = (UserService) getServletContext().getAttribute(USER_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userService.readUsers();
        req.setAttribute(USERS, users);
        req.getRequestDispatcher(ALL_USERS_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
