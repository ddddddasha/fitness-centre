package app.servlets.fitness.controllers.subscription;

import app.servlets.fitness.dto.subscription.SubscriptionRequest;
import app.servlets.fitness.dto.subscription.SubscriptionResponse;
import app.servlets.fitness.services.subscription.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    @PostMapping(value = "/subscription")
    public SubscriptionResponse create(@Valid @RequestBody SubscriptionRequest subscriptionRequest) {
        return subscriptionService.create(subscriptionRequest);
    }

    @GetMapping(value = "/subscriptions")
    public List<SubscriptionResponse> read() {
        return subscriptionService.read();
    }

    @PutMapping(value = "/subscription/{id}")
    public SubscriptionResponse update(@PathVariable Long id, @Valid @RequestBody SubscriptionRequest subscriptionRequest) {
        return subscriptionService.update(id, subscriptionRequest);
    }

    @DeleteMapping(value = "/subscription/{id}")
    public boolean delete(@PathVariable @Min(1) Long id) {
        return subscriptionService.delete(id);
    }

    @GetMapping(value = "/subscription/{id}")
    public SubscriptionResponse findSubscriptionById(@PathVariable @Min(1) Long id) {
        return subscriptionService.findById(id);
    }

}
