package app.servlets.fitness.controllers.subscription;

import app.servlets.fitness.entities.Subscription;
import app.servlets.fitness.entities.enums.SubscriptionCategory;
import app.servlets.fitness.services.SubscriptionService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static app.servlets.fitness.util.Constants.*;

@WebServlet(urlPatterns = "/search/subscription", loadOnStartup = 1)
public class SearchSubscriptionController extends HttpServlet {
    private SubscriptionService subscriptionService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String subscriptionCategoryParam = req.getParameter(SUBSCRIPTION_CATEGORY);
        List<Subscription> matchingSubscriptions;

        if (subscriptionCategoryParam != null && !subscriptionCategoryParam.isBlank()) {
            SubscriptionCategory subscriptionCategory = SubscriptionCategory.valueOf(subscriptionCategoryParam);
            matchingSubscriptions = subscriptionService.findBySubscriptionCategory(subscriptionCategory);
        } else {
            matchingSubscriptions = subscriptionService.readSubscriptions();
        }

        req.setAttribute(SUBSCRIPTIONS, matchingSubscriptions);
        req.getRequestDispatcher(FIND_SUBS_PAGE).forward(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        subscriptionService = (SubscriptionService) config.getServletContext().getAttribute(SUBSCRIPTION_SERVICE);
    }
}
