package app.servlets.fitness.exseptions.validation;

import java.util.List;

public class ValidationException extends RuntimeException {
    private final List<Error> validationErrors;

    public ValidationException(List<Error> validationErrors) {
        this.validationErrors = validationErrors;
    }

    public List<Error> getValidationErrors() {
        return validationErrors;
    }
}
