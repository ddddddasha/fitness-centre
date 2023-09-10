package app.servlets.fitness.services.schedule;

import app.servlets.fitness.dto.schedule.ScheduleResponse;
import app.servlets.fitness.feignClient.ScheduleClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleClient scheduleClient;

    @Override
    public List<ScheduleResponse> getSchedule() {
        return scheduleClient.getSchedule();
    }
}
