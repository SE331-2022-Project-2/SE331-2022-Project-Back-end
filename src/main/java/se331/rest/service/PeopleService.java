package se331.rest.service;

import org.springframework.data.domain.Page;
import se331.rest.entity.People;
import se331.rest.entity.Vaccine;

import java.util.List;

public interface PeopleService {
    Integer getPeopleSize();

    Page<People> getPeoples(Integer pageSize, Integer page);

    People getPeople(Long id);

    People save(People people);

    List<People> getAllPeople();
    //Page<People> getPeoples()
}
