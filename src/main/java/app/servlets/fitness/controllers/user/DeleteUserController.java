package app.servlets.fitness.controllers.user;

import app.servlets.fitness.exseptions.UserSearchException;
import app.servlets.fitness.services.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


import static app.servlets.fitness.util.Constants.*;
import static app.servlets.fitness.util.Constants.DELETE_SUBSCRIPTION_EXCEPTION_PAGE;

@WebServlet(urlPatterns = "/deleteUser", loadOnStartup = 1)
public class DeleteUserController extends HttpServlet {
    private UserService userService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String userId = req.getParameter(ID);
            userService.deleteById(Long.parseLong(userId));
            resp.sendRedirect(ADMIN_READ_USERS_URL);
        } catch (UserSearchException e) {
            req.setAttribute(ERROR_MESSAGE, e.getMessage());
            req.getRequestDispatcher(DELETE_SUBSCRIPTION_EXCEPTION_PAGE).forward(req, resp);
        }
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = (UserService) config.getServletContext().getAttribute(USER_SERVICE);
    }
}
