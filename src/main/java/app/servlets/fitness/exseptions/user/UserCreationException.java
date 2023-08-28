package app.servlets.fitness.exseptions.user;

public class UserCreationException extends RuntimeException {

    public UserCreationException(String message) {
        super(message);
    }
}