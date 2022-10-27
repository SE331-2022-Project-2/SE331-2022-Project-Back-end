package se331.rest.security.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import se331.rest.entity.People;
import se331.rest.security.entity.User;
import se331.rest.security.repository.UserRepository;

import java.util.Optional;

@Profile("db")
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Page<User> getUsers(Integer pageSize, Integer page) {
        return userRepository.findAll(PageRequest.of(page-1,pageSize));
    }


    @Override
    public Optional<User> findByID(Long id){
        return userRepository.findById(id);
    }

    @Override
    public User getUsers(Long id) {
        return userRepository.findById(id).orElse(null);
    }

}
