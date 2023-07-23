package app.servlets.fitness.controllers.subscription;

import app.servlets.fitness.exseptions.SubscriptionSearchException;
import app.servlets.fitness.services.SubscriptionService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static app.servlets.fitness.util.Constants.*;
import static app.servlets.fitness.util.Constants.DELETE_SUBSCRIPTION_EXCEPTION_PAGE;

@WebServlet(urlPatterns = "/subscription/delete", loadOnStartup = 1)
public class DeleteSubscriptionController extends HttpServlet {
    private SubscriptionService subscriptionService;

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String subId = req.getParameter(ID);
        try {
            subscriptionService.deleteById(Long.parseLong(subId));
        } catch (SubscriptionSearchException e) {
            req.setAttribute(ERROR_MESSAGE, e.getMessage());
            req.getRequestDispatcher(DELETE_SUBSCRIPTION_EXCEPTION_PAGE).forward(req, resp);
        }
        resp.sendRedirect(SUBSCRIPTIONS_URL);
    }


    @Override
    public void init(ServletConfig config) throws ServletException {
        subscriptionService = (SubscriptionService) config.getServletContext().getAttribute(SUBSCRIPTION_SERVICE);
    }
}
