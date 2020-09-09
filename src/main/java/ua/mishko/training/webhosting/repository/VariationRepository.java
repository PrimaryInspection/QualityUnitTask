package ua.mishko.training.webhosting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.mishko.training.webhosting.domain.Variation;

public interface VariationRepository extends JpaRepository<Variation,Long> {
}
