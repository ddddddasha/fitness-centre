package app.servlets.fitness.dto.error;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Builder
public class ErrorResponse {

    private final String message;
    private final LocalDateTime time;
    private final HttpStatus status;
}
