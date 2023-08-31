package app.servlets.fitness.controllers;

import app.servlets.fitness.dto.ScheduleResponse;
import app.servlets.fitness.entities.enums.SubscriptionCategory;
import app.servlets.fitness.services.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    @GetMapping("/schedule/{subscriptionCategory}")
    public List<ScheduleResponse> getSchedule(@PathVariable SubscriptionCategory subscriptionCategory) {
        return scheduleService.getSchedule(subscriptionCategory);
    }
}
