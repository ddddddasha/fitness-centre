package app.servlets.fitness.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "descriptionClient", url = "${clients.description.url}")
public interface DescriptionClient {

    @GetMapping
    String getDescription(@RequestParam String fileName);
}
