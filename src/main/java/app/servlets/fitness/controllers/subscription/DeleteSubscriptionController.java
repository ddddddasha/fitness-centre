package app.servlets.fitness.controllers.subscription;

import app.servlets.fitness.services.SubscriptionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static app.servlets.fitness.util.Constants.*;

@WebServlet(urlPatterns = "/subscription/delete")
public class DeleteSubscriptionController extends HttpServlet {
    private SubscriptionService subscriptionService;

    @Override
    public void init() throws ServletException {
        super.init();
        subscriptionService = (SubscriptionService) getServletContext().getAttribute(SUBSCRIPTION_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String subId = req.getParameter(ID);
        subscriptionService.deleteById(subId);
        resp.sendRedirect(SUBSCRIPTIONS_URL);
    }
}
