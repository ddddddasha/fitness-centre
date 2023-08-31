package app.servlets.fitness.feignClient;

import app.servlets.fitness.dto.ScheduleResponse;
import app.servlets.fitness.entities.enums.SubscriptionCategory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(value = "scheduleClient", url = "${clients.schedule.url}")
public interface ScheduleClient {

    @GetMapping
    List<ScheduleResponse> getSchedule(@RequestParam SubscriptionCategory subscriptionCategory);
}
