package app.servlets.fitness.controllers.user;

import app.servlets.fitness.entities.User;
import app.servlets.fitness.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

import static app.servlets.fitness.util.Constants.*;

@WebServlet(urlPatterns = "/user/edit")
public class EditUserController extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = (UserService) getServletContext().getAttribute(USER_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter(ID);

        Optional.ofNullable(userService.getById(userId))
                .ifPresentOrElse(
                        user -> {
                            req.setAttribute(USER, user);
                            try {
                                req.getRequestDispatcher(EDIT_USER_PAGE).forward(req, resp);
                            } catch (ServletException | IOException e) {
                                throw new RuntimeException(e);
                            }
                        },
                        () -> {
                            try {
                                resp.sendRedirect(INDEX_PAGE);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter(ID);
        String firstName = req.getParameter(FIRST_NAME);
        String lastName = req.getParameter(LAST_NAME);
        int age = Integer.parseInt(req.getParameter(AGE));
        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);
        User user = User.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .age(age)
                .login(login)
                .password(password)
                .build();
        userService.updateUser(user);
        resp.sendRedirect(ALL_USERS_PAGE);
    }
}
