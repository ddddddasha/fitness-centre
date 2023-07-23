package app.servlets.fitness.exseptions;

public class UserCreationException extends Exception{
    private final String message;

    public UserCreationException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
