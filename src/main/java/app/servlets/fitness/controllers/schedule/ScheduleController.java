package app.servlets.fitness.controllers.schedule;

import app.servlets.fitness.dto.schedule.ScheduleResponse;
import app.servlets.fitness.services.schedule.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @GetMapping(value = "/schedule")
    public List<ScheduleResponse> getSchedule() {
        return scheduleService.getSchedule();
    }
}
