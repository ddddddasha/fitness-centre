package app.servlets.fitness.exseptions.purchase;

import javax.persistence.EntityNotFoundException;

public class PurchaseNotFoundException extends EntityNotFoundException {
    public PurchaseNotFoundException(String message){
        super(message);
    }
}