package se331.rest.security.dao;

import org.springframework.data.domain.Page;
import se331.rest.entity.People;
import se331.rest.security.entity.User;

import java.util.Optional;

public interface UserDao {
    User save(User user);

    Page<User> getUsers(Integer pageSize, Integer page);

    Optional<User> findByID(Long id);

    User getUsers(Long id);
}
