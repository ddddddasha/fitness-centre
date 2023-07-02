package app.servlets.fitness.controllers.user;

import app.servlets.fitness.entities.User;
import app.servlets.fitness.services.UserService;
import app.servlets.fitness.services.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

import static app.servlets.fitness.util.Constants.*;

@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = (UserService) getServletContext().getAttribute(USER_SERVICE);
        if (userService == null) {
            userService = new UserServiceImpl();
            getServletContext().setAttribute(USER_SERVICE, userService);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(SIGN_IN_PAGE).forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);
        User user = userService.logIn(login, password);

        HttpSession session = req.getSession();

        Optional.ofNullable(user)
                .ifPresentOrElse(
                        u -> {
                            session.setAttribute(LOGIN, u.getLogin());
                            session.setAttribute(ROLE, u.getRole());
                            try {
                                req.getRequestDispatcher(INDEX_PAGE).forward(req, resp);
                            } catch (ServletException | IOException e) {
                                e.printStackTrace();
                            }
                        },
                        () -> {
                            req.setAttribute(ERROR_MESSAGE, ERROR_LOGIN_MESSAGE);
                            try {
                                req.getRequestDispatcher(SIGN_IN_PAGE).forward(req, resp);
                            } catch (ServletException | IOException e) {
                                e.printStackTrace();
                            }
                        }
                );
    }
}
