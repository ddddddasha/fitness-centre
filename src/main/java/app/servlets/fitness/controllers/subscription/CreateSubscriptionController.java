package app.servlets.fitness.controllers.subscription;

import app.servlets.fitness.dto.SubscriptionDto;
import app.servlets.fitness.mappers.SubscriptionDtoMapper;
import app.servlets.fitness.services.SubscriptionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static app.servlets.fitness.util.Constants.*;

@WebServlet(urlPatterns = "/subscription/create")
public class CreateSubscriptionController extends HttpServlet {
    private SubscriptionDtoMapper subscriptionDtoMapper;
    private SubscriptionService subscriptionService;

    @Override
    public void init() throws ServletException {
        super.init();
        subscriptionService = (SubscriptionService) getServletContext().getAttribute(SUBSCRIPTION_SERVICE);
        subscriptionDtoMapper = (SubscriptionDtoMapper) getServletContext().getAttribute(SUBSCRIPTION_DTO_MAPPER);
        if (subscriptionDtoMapper == null) {
            subscriptionDtoMapper = new SubscriptionDtoMapper();
            getServletContext().setAttribute(SUBSCRIPTION_DTO_MAPPER, subscriptionDtoMapper);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SubscriptionDto subscriptionDto = subscriptionDtoMapper.buildSubscriptionDto(req.getParameter(SUBSCRIPTION_CATEGORY),
                req.getParameter(SUBSCRIPTION_NAME),
                Integer.parseInt(req.getParameter(SUBSCRIPTION_PRICE)),
                Integer.parseInt(req.getParameter(SUBSCRIPTION_PERIOD)),
                Integer.parseInt(req.getParameter(NUMBER_OF_GUEST_VISITS)),
                Integer.parseInt(req.getParameter(MAX_SUBSCRIPTION_STOP)),
                req.getParameter(DESCRIPTION)
        );
        subscriptionService.createSubscription(subscriptionDtoMapper.toEntity(subscriptionDto));
        req.getRequestDispatcher(INDEX_PAGE).forward(req, resp);
    }
}