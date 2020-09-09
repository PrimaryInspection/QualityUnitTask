package ua.mishko.training.webhosting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.mishko.training.webhosting.domain.SubCategory;

public interface SubCategoryRepository extends JpaRepository<SubCategory,Long> {
}
