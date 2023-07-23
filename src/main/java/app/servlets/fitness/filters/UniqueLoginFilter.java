package app.servlets.fitness.filters;

import app.servlets.fitness.entities.User;
import app.servlets.fitness.services.UserService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static app.servlets.fitness.util.Constants.*;

@WebFilter(urlPatterns = "/user/create")
public class UniqueLoginFilter extends HttpFilter {

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        UserService userService = (UserService) getServletContext().getAttribute(USER_SERVICE);
        String login = request.getParameter(LOGIN);

        User user = userService.getByLogin(login);
        if (user != null) {
            request.setAttribute(ERROR_MESSAGE_EMAIL_ALREADY_EXISTS, EMAIL_ALREADY_EXISTS);
            request.getRequestDispatcher(USER_REGISTRATION_PAGE).forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }
}
