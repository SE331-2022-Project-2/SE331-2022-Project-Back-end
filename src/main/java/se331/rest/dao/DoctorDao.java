package se331.rest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.rest.entity.Doctor;
import se331.rest.entity.People;

import java.util.Optional;


public interface DoctorDao {
    Integer getDoctorSize();
    Page<Doctor> getDoctors(Integer pageSize, Integer page);
    Doctor getDoctors(Long id);

    Doctor save(Doctor doctor);

    Optional<Doctor> findByID(Long id);

    Page<Doctor> getDoctor(Pageable pageRequest);
}
