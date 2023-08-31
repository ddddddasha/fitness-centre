package app.servlets.fitness.services;

import app.servlets.fitness.dto.ScheduleResponse;
import app.servlets.fitness.entities.enums.SubscriptionCategory;

import java.util.List;

public interface ScheduleService {
    List<ScheduleResponse> getSchedule(SubscriptionCategory subscriptionCategory);
}