package app.servlets.fitness.controllers.exception;

import app.servlets.fitness.dto.error.ErrorResponse;
import app.servlets.fitness.exseptions.purchase.PurchaseCreationException;
import app.servlets.fitness.exseptions.purchase.PurchaseNotFoundException;
import app.servlets.fitness.exseptions.subscription.SubscriptionCreationException;
import app.servlets.fitness.exseptions.subscription.SubscriptionNotFoundException;
import app.servlets.fitness.exseptions.user.UserCreationException;
import app.servlets.fitness.exseptions.user.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Slf4j
@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(UserNotFoundException.class)
    public ErrorResponse handleUserNotFoundException(UserNotFoundException exception) {
        log.warn("EXCEPTION {}", exception.getMessage());
        return ErrorResponse.builder()

                .message(exception.getMessage())
                .time(LocalDateTime.now())
                .status(BAD_REQUEST)
                .build();
    }

    @ExceptionHandler(SubscriptionNotFoundException.class)
    public ErrorResponse handleSubscriptionNotFoundException(SubscriptionNotFoundException exception) {
        log.warn("EXCEPTION {}", exception.getMessage());
        return ErrorResponse.builder()
                .message(exception.getMessage())
                .time(LocalDateTime.now())
                .status(BAD_REQUEST)
                .build();
    }

    @ExceptionHandler(PurchaseNotFoundException.class)
    public ErrorResponse handlePurchaseNotFoundException(PurchaseNotFoundException exception) {
        log.warn("EXCEPTION {}", exception.getMessage());
        return ErrorResponse.builder()
                .message(exception.getMessage())
                .time(LocalDateTime.now())
                .status(BAD_REQUEST)
                .build();
    }

    @ExceptionHandler(UserCreationException.class)
    public ErrorResponse handleUserCreationException(UserCreationException exception) {
        log.warn("EXCEPTION {}", exception.getMessage());
        return ErrorResponse.builder()
                .message(exception.getMessage())
                .time(LocalDateTime.now())
                .status(BAD_REQUEST)
                .build();
    }

    @ExceptionHandler(PurchaseCreationException.class)
    public ErrorResponse handlePurchaseCreationException(PurchaseCreationException exception) {
        log.warn("EXCEPTION {}", exception.getMessage());
        return ErrorResponse.builder()
                .message(exception.getMessage())
                .time(LocalDateTime.now())
                .status(BAD_REQUEST)
                .build();
    }

    @ExceptionHandler(SubscriptionCreationException.class)
    public ErrorResponse handlePurchaseCreationException(SubscriptionCreationException exception) {
        log.warn("EXCEPTION {}", exception.getMessage());
        return ErrorResponse.builder()
                .message(exception.getMessage())
                .time(LocalDateTime.now())
                .status(BAD_REQUEST)
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleValidationException(MethodArgumentNotValidException exception) {


        log.warn("Validation Exception: {}", exception.getMessage());
        return ErrorResponse.builder()
                .message(exception.getMessage())
                .time(LocalDateTime.now())
                .status(BAD_REQUEST)
                .build();
    }
}
