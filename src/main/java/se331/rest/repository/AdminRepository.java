package se331.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.rest.entity.Admin;


import java.util.List;


public interface AdminRepository extends JpaRepository<Admin,Long> {
    List<Admin> findAll();
}
