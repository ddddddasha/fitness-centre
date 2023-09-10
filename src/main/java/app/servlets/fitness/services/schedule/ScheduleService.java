package app.servlets.fitness.services.schedule;

import app.servlets.fitness.dto.schedule.ScheduleResponse;

import java.util.List;

public interface ScheduleService {

    List<ScheduleResponse> getSchedule();
}