package se331.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import se331.rest.dao.DoctorDao;
import se331.rest.entity.Doctor;

import javax.transaction.Transactional;

@Service
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    DoctorDao doctorDao;

    @Override
    public Page<Doctor> getDoctors(Integer pageSize, Integer page) {
        return doctorDao.getDoctors(pageSize,page);
    }

    @Override
    public Doctor getDoctor(Long id) {
        return doctorDao.getDoctors(id);
    }

    @Override
    @Transactional
    public Doctor save(Doctor doctor) {
        return doctorDao.save(doctor);
    }
}
