package app.servlets.fitness.exseptions;

public class UserSearchException extends Exception{
    private final String message;

    public UserSearchException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
