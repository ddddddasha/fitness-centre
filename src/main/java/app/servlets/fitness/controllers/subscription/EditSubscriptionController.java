package app.servlets.fitness.controllers.subscription;

import app.servlets.fitness.entities.Subscription;
import app.servlets.fitness.mappers.SubscriptionMapper;
import app.servlets.fitness.services.SubscriptionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

import static app.servlets.fitness.util.Constants.*;

@WebServlet(urlPatterns = "/subscription/edit")
public class EditSubscriptionController extends HttpServlet {
    private SubscriptionService subscriptionService;
    private SubscriptionMapper subscriptionMapper;

    @Override
    public void init() throws ServletException {
        super.init();
        subscriptionService = (SubscriptionService) getServletContext().getAttribute(SUBSCRIPTION_SERVICE);
        subscriptionMapper = (SubscriptionMapper) getServletContext().getAttribute(SUBSCRIPTION_MAPPER);
        if (subscriptionMapper == null) {
            subscriptionMapper = new SubscriptionMapper();
            getServletContext().setAttribute(SUBSCRIPTION_DTO_MAPPER, subscriptionMapper);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String subscriptionId = req.getParameter(ID);

        Optional<Subscription> optionalSubscription = Optional.ofNullable(subscriptionService.getById(subscriptionId));

        optionalSubscription.ifPresent(subscription -> {
            req.setAttribute(SUBSCRIPTION, subscription);
            try {
                req.getRequestDispatcher(EDIT_SUBSCRIPTION_PAGE).forward(req, resp);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        });

        if (optionalSubscription.isEmpty()) {
            resp.sendRedirect(SUBSCRIPTIONS_URL);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter(ID);
        String subscriptionName = req.getParameter(SUBSCRIPTION_NAME);
        int subscriptionPrice = Integer.parseInt(req.getParameter(SUBSCRIPTION_PRICE));
        int subscriptionPeriod = Integer.parseInt(req.getParameter(SUBSCRIPTION_PERIOD));
        int numberOfGuestVisits = Integer.parseInt(req.getParameter(NUMBER_OF_GUEST_VISITS));
        int maxSubscriptionStop = Integer.parseInt(req.getParameter(MAX_SUBSCRIPTION_STOP));
        String description = req.getParameter(DESCRIPTION);

        Subscription subscription = subscriptionMapper.buildSubscription(id, subscriptionName, subscriptionPrice, subscriptionPeriod,
                numberOfGuestVisits, maxSubscriptionStop, description);
        subscriptionService.updateSubscription(subscription);

        resp.sendRedirect(SUBSCRIPTIONS_URL);
    }
}
