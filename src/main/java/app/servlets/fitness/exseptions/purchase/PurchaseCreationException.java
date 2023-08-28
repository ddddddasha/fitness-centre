package app.servlets.fitness.exseptions.purchase;

import javax.persistence.EntityNotFoundException;

public class PurchaseCreationException extends RuntimeException {
    public PurchaseCreationException(String message){
        super(message);
    }
}
