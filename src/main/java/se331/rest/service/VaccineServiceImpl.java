package se331.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.rest.dao.DoctorDao;
import se331.rest.dao.PeopleDao;
import se331.rest.dao.VaccineDao;
import se331.rest.entity.Doctor;
import se331.rest.entity.People;
import se331.rest.entity.Vaccine;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class VaccineServiceImpl implements VaccineService{
    @Autowired
    VaccineDao vaccineDao;

    @Autowired
    PeopleDao peopleDao;

    @Autowired
    DoctorDao doctorDao;

    @Override
    public List<Vaccine> getAllVaccine() {
        return vaccineDao.getVaccine(Pageable.unpaged()).getContent();
    }

    @Override
    public Page<Vaccine> getVaccine(Integer page, Integer pageSize) {
        return vaccineDao.getVaccine(PageRequest.of(page,pageSize));
    }

    @Override
    @Transactional
    public Vaccine save(Vaccine vaccine) {
        People people = peopleDao.findByID(vaccine.getPatient().getId()).orElse(null);
        vaccine.setPatient(people);
        people.getHasVaccines().add(vaccine);

        Doctor doctor = doctorDao.findByID(vaccine.getDoctor().getId()).orElse(null);
        vaccine.setDoctor(doctor);
        doctor.getDoVaccines().add(vaccine);

        return vaccineDao.save(vaccine);
    }
}
