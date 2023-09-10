package app.servlets.fitness.dto.schedule;

import app.servlets.fitness.entities.enums.SubscriptionCategory;
import lombok.Builder;
import lombok.Data;

import java.time.DayOfWeek;

@Data
@Builder
public class ScheduleResponse {

    private SubscriptionCategory subscriptionCategory;
    private DayOfWeek dayOfWeek;
    private String coachName;
    private String duration;
}
