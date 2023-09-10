package app.servlets.fitness.feignClient;

import app.servlets.fitness.dto.schedule.ScheduleResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Component
@FeignClient(value = "schedule-api")
public interface ScheduleClient {

    @GetMapping
    List<ScheduleResponse> getSchedule();
}

