package app.servlets.fitness.controllers;

import app.servlets.fitness.dto.DescriptionResponse;
import app.servlets.fitness.services.DescriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class DescriptionController {
    private final DescriptionService descriptionService;

    @GetMapping("/description/{fileName}")
    public DescriptionResponse getDescription(@PathVariable String fileName) {
        return descriptionService.getDescription(fileName);
    }
}
