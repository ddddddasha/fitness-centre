package app.servlets.fitness.dto.error;

import app.servlets.fitness.exseptions.validation.ValidationError;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class ValidationErrorResponse {
    private final List<ValidationError> validationErrors;
    private final String fieldName;
    private final String message;
    private final LocalDateTime time;
    private final HttpStatus status;
}
