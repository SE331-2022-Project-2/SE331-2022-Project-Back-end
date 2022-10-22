package se331.rest.service;

import org.springframework.data.domain.Page;
import se331.rest.entity.People;

public interface PeopleService {
    Integer getPeopleSize();

    Page<People> getPeoples(Integer pageSize, Integer page);

    People getPeople(Long id);

    People save(People people);
    //Page<People> getPeoples()
}
