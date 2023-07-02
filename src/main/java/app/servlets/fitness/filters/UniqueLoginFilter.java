package app.servlets.fitness.filters;

import app.servlets.fitness.services.UserService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

import static app.servlets.fitness.util.Constants.*;

@WebFilter(urlPatterns = "/user/create")
public class UniqueLoginFilter extends HttpFilter {

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) {
        UserService userService = (UserService) getServletContext().getAttribute(USER_SERVICE);
        String login = request.getParameter(LOGIN);

        Optional.ofNullable(userService.getByLogin(login))
                .ifPresentOrElse(
                        user -> {
                            request.setAttribute(ERROR_MESSAGE_EMAIL_ALREADY_EXISTS, EMAIL_ALREADY_EXISTS);
                            try {
                                request.getRequestDispatcher(USER_REGISTRATION_PAGE).forward(request, response);
                            } catch (ServletException | IOException e) {
                                e.printStackTrace();
                            }
                        },
                        () -> {
                            try {
                                chain.doFilter(request, response);
                            } catch (IOException | ServletException e) {
                                e.printStackTrace();
                            }
                        }
                );
    }
}
