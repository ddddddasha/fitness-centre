package app.servlets.fitness.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ScheduleResponse {

    private String description;
}
