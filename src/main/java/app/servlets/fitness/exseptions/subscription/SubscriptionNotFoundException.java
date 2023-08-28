package app.servlets.fitness.exseptions.subscription;

import javax.persistence.EntityNotFoundException;

public class SubscriptionNotFoundException extends EntityNotFoundException {
    public SubscriptionNotFoundException(String message){
        super(message);
    }
}