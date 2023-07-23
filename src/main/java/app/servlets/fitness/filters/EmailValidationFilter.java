package app.servlets.fitness.filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static app.servlets.fitness.util.Constants.*;

@WebFilter(urlPatterns = "/user/create")
public class EmailValidationFilter extends HttpFilter {
    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String login = request.getParameter(LOGIN);
        if (isEmailValid(login)) {
            chain.doFilter(request, response);
        } else {
            request.setAttribute(ERROR_MESSAGE_EMAIL, INCORRECT_EMAIL);
            request.getRequestDispatcher(USER_REGISTRATION_PAGE).forward(request, response);
        }
    }

    private boolean isEmailValid(String email) {
        return email.matches(EMAIL_REGEX);
    }
}
