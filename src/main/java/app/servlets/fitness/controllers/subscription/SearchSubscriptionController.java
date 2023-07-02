package app.servlets.fitness.controllers.subscription;

import app.servlets.fitness.entities.Subscription;
import app.servlets.fitness.services.SubscriptionService;
import app.servlets.fitness.services.SubscriptionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static app.servlets.fitness.util.Constants.*;

@WebServlet(urlPatterns = "/search/subscription")
public class SearchSubscriptionController extends HttpServlet {
    private SubscriptionService subscriptionService;

    @Override
    public void init() throws ServletException {
        super.init();
        subscriptionService = (SubscriptionService) getServletContext().getAttribute(SUBSCRIPTION_SERVICE);
        if (subscriptionService == null) {
            subscriptionService = new SubscriptionServiceImpl();
            getServletContext().setAttribute(SUBSCRIPTION_SERVICE, subscriptionService);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String subscriptionTypeParam = req.getParameter(SUBSCRIPTION_TYPE);
        if (subscriptionTypeParam == null || subscriptionTypeParam.isEmpty()) {
            resp.sendRedirect(req.getContextPath() + INDEX_PAGE);
            return;
        }
        List<Subscription> matchingSubscriptions = subscriptionService.findBySubscriptionCategory(subscriptionTypeParam);
        req.setAttribute(SUBSCRIPTIONS, matchingSubscriptions);
        req.getRequestDispatcher(FIND_SUBS_PAGE).forward(req, resp);
    }
}
