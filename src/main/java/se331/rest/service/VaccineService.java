package se331.rest.service;

import org.springframework.data.domain.Page;
import se331.rest.entity.Vaccine;

import java.util.List;

public interface VaccineService {
    List<Vaccine> getAllVaccine();
    Page<Vaccine> getVaccine(Integer page, Integer pageSize);
}
