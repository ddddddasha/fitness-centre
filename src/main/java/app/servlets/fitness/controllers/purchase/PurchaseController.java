package app.servlets.fitness.controllers.purchase;

import app.servlets.fitness.dto.purchase.PurchaseRequest;
import app.servlets.fitness.dto.purchase.PurchaseResponse;
import app.servlets.fitness.services.purchase.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PurchaseController {

    private final PurchaseService purchaseService;

    @PostMapping(value = "/purchase")
    public PurchaseResponse create(@Valid @RequestBody PurchaseRequest purchaseRequest) {
        return purchaseService.create(purchaseRequest);
    }

    @GetMapping(value = "/purchases")
    public List<PurchaseResponse> read(){
        return purchaseService.read();
    }

    @GetMapping(value = "/purchaseById/{id}")
    public PurchaseResponse findById(@PathVariable Long id){
        return purchaseService.findById(id);
    }

    @PutMapping(value = "/purchase/{id}")
    public PurchaseResponse update(@PathVariable Long id, @Valid @RequestBody PurchaseRequest purchaseRequest) {
        return purchaseService.update(id, purchaseRequest);
    }

    @DeleteMapping(value = "/purchase/{id}")
    public void delete(@PathVariable Long id) {
        purchaseService.delete(id);
    }
}
