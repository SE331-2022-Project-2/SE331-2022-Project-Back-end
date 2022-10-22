package se331.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import se331.rest.dao.PeopleDao;
import se331.rest.entity.People;

import javax.transaction.Transactional;

@Service
public class PeopleServiceImpl implements PeopleService {
    @Autowired
    PeopleDao peopleDao;

    @Override
    public Integer getPeopleSize() {
        return peopleDao.getPeopleSize();
    }

    @Override
    public Page<People> getPeoples(Integer pageSize, Integer page) {
        return peopleDao.getPeoples(pageSize,page);
    }

    @Override
    public People getPeople(Long id) {
        return peopleDao.getPeoples(id);
    }

    @Override
    @Transactional
    public People save(People people) {
        return peopleDao.save(people);
    }
}
