package app.servlets.fitness.exseptions;

public class SubscriptionCreationException extends Exception {
    private final String message;

    public SubscriptionCreationException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
