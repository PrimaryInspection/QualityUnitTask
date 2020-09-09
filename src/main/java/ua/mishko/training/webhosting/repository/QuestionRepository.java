package ua.mishko.training.webhosting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.mishko.training.webhosting.domain.Question;

public interface QuestionRepository extends JpaRepository<Question,Long> {
}
