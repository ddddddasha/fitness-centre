package app.servlets.fitness.repositories.purchase;

import app.servlets.fitness.entities.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
