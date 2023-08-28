package app.servlets.fitness.services;

import app.servlets.fitness.dto.DescriptionResponse;

import java.math.BigDecimal;

public interface DescriptionService {
    DescriptionResponse getDescription(String fileName);
}
