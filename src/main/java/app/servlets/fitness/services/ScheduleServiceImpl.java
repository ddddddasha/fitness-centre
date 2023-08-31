package app.servlets.fitness.services;

import app.servlets.fitness.dto.ScheduleResponse;
import app.servlets.fitness.entities.enums.SubscriptionCategory;
import app.servlets.fitness.feignClient.ScheduleClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleClient scheduleClient;

    @Override
    public List<ScheduleResponse> getSchedule(SubscriptionCategory subscriptionCategory) {
        return scheduleClient.getSchedule(subscriptionCategory);
    }
}
