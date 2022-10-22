package se331.rest.dao;

import org.springframework.data.domain.Page;
import se331.rest.entity.Doctor;


public interface DoctorDao {
    Integer getDoctorSize();
    Page<Doctor> getDoctors(Integer pageSize, Integer page);
    Doctor getDoctors(Long id);

    Doctor save(Doctor doctor);
}
