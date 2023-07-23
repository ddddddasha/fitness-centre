package app.servlets.fitness.exseptions;

public class SubscriptionSearchException extends Exception{
    private final String message;

    public SubscriptionSearchException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
