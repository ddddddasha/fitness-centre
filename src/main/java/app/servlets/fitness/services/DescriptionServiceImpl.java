package app.servlets.fitness.services;

import app.servlets.fitness.dto.DescriptionResponse;
import app.servlets.fitness.entities.enums.PaymentStatus;
import app.servlets.fitness.feignClient.DescriptionClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class DescriptionServiceImpl implements DescriptionService{

    private final DescriptionClient descriptionClient;

    @Override
    public DescriptionResponse getDescription(String fileName) {
        String description = descriptionClient.getDescription(fileName);
        return DescriptionResponse.builder()
                .description(description)
                .build();
    }
}
