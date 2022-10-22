package se331.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.rest.entity.People;

import java.util.List;

public interface PeopleRepository extends JpaRepository<People,Long> {
    List<People> findAll();
}
