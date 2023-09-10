package app.servlets.fitness.controllers.exception;

import app.servlets.fitness.dto.error.ErrorResponse;
import app.servlets.fitness.dto.error.ValidationErrorResponse;
import app.servlets.fitness.exseptions.ValidationError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import static app.servlets.fitness.util.Constants.*;
import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Slf4j
@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(EntityNotFoundException.class)
    public ErrorResponse handleEntityNotFoundException(EntityNotFoundException exception) {
        log.warn(EXCEPTION, exception.getMessage());
        return ErrorResponse.builder()
                .message(exception.getMessage())
                .time(now())
                .status(BAD_REQUEST)
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ValidationErrorResponse handleValidationException(MethodArgumentNotValidException exception) {
        log.warn(VALIDATION_ERROR, exception.getMessage());
        List<ValidationError> validationErrors = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> new ValidationError(fieldError.getDefaultMessage(), fieldError.getField()))
                .collect(Collectors.toList());
        return ValidationErrorResponse.builder()
                .time(now())
                .status(BAD_REQUEST)
                .validationErrors(validationErrors)
                .build();
    }
}
