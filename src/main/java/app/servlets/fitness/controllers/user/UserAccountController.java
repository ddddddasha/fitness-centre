package app.servlets.fitness.controllers.user;

import app.servlets.fitness.dto.PurchaseDto;
import app.servlets.fitness.dto.UserDto;
import app.servlets.fitness.entities.Purchase;
import app.servlets.fitness.entities.User;
import app.servlets.fitness.exseptions.UserSearchException;
import app.servlets.fitness.services.PurchaseService;
import app.servlets.fitness.services.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static app.servlets.fitness.util.Constants.*;
import static app.servlets.fitness.util.Constants.PURCHASE_SERVICE;

@WebServlet(urlPatterns = "/user/account", loadOnStartup = 1)
public class UserAccountController extends HttpServlet {
    private UserService userService;
    private PurchaseService purchaseService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String login = (String) session.getAttribute(LOGIN);
        try {
            UserDto user = userService.getByLogin(login);
            req.setAttribute(USER, user);
            List<PurchaseDto> userPurchases = purchaseService.getUserPurchases(user.getId());
            req.setAttribute("userPurchases", userPurchases);
            req.getRequestDispatcher(CLIENT_HOME_PAGE).forward(req, resp);
        } catch (UserSearchException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = (UserService) config.getServletContext().getAttribute(USER_SERVICE);
        purchaseService = (PurchaseService) config.getServletContext().getAttribute(PURCHASE_SERVICE);
    }
}
