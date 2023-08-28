package app.servlets.fitness.exseptions.user;

import javax.persistence.EntityNotFoundException;

public class UserNotFoundException extends EntityNotFoundException {
    public UserNotFoundException(String message){
        super(message);
    }
}
