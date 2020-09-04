package ua.mishko.training.webhosting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.mishko.training.webhosting.domain.Request;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request,Long> {

    @Query(
            value = "SELECT  * From request ORDER BY request.id ASC",
            nativeQuery = true
    )
    List<Request> findAllRequest();



}
