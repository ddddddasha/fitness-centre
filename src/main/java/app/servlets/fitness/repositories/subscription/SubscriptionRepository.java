package app.servlets.fitness.repositories.subscription;

import app.servlets.fitness.entities.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}
