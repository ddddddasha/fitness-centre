package app.servlets.fitness.controllers.subscription;

import app.servlets.fitness.creators.ServiceCreator;
import app.servlets.fitness.entities.Subscription;
import app.servlets.fitness.services.PurchaseService;
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
import static app.servlets.fitness.util.Constants.PURCHASE_SERVICE;

@WebServlet(urlPatterns = "/subscription", loadOnStartup = 0)
public class ReadSubscriptionController extends HttpServlet {
    private SubscriptionService subscriptionService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Subscription> subscriptions = subscriptionService.readSubscriptions();
        req.setAttribute(SUBSCRIPTIONS, subscriptions);
        req.getRequestDispatcher(ALL_SUBSCRIPTIONS_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {

        ServiceCreator serviceCreator = new ServiceCreator();
        subscriptionService = serviceCreator.buildSubscriptionService();
        config.getServletContext().setAttribute(SUBSCRIPTION_SERVICE, subscriptionService);

        PurchaseService purchaseService = serviceCreator.buildPurchaseService();
        config.getServletContext().setAttribute(PURCHASE_SERVICE, purchaseService);
    }
}
