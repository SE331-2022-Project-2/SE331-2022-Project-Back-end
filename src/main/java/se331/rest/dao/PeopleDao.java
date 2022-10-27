package se331.rest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.rest.entity.People;
import se331.rest.security.entity.User;

import javax.persistence.OneToOne;
import java.util.Optional;

public interface PeopleDao {
    Integer getPeopleSize();
    Page<People> getPeoples(Integer pageSize, Integer page);
    People getPeoples(Long id);
    Page<People> getPeople(Pageable pageRequest);
    People save(People people);
    //Page<People> getPeoples(String name, Pageable page);
    Optional<People> findByID(Long id);

}
