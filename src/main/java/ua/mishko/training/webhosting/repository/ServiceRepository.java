package ua.mishko.training.webhosting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.mishko.training.webhosting.domain.Service;

public interface ServiceRepository extends JpaRepository<Service,Long> {
}
