package ua.mishko.training.webhosting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.mishko.training.webhosting.domain.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
