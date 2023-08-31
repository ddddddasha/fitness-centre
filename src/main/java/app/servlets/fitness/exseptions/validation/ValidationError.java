package app.servlets.fitness.exseptions.validation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
@AllArgsConstructor
public class ValidationError {
    private final String message;
    private final String fieldError;
}
