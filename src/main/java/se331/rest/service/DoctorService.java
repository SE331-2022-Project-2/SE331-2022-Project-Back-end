package se331.rest.service;

import org.springframework.data.domain.Page;
import se331.rest.entity.Doctor;
import se331.rest.entity.People;

import java.util.List;

public interface DoctorService {
    Page<Doctor> getDoctors(Integer pageSize, Integer page);

    Doctor getDoctor(Long id);

    Doctor save(Doctor doctor);

    List<Doctor> getAllDoctor();

}
