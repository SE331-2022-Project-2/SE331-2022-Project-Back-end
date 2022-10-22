package se331.rest.util;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import se331.rest.entity.*;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(imports = Collectors.class)
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);

    PeopleDTO getPeopleDTO(People people);
    VaccineDTO getVaccineDTO(Vaccine vaccine);
    DoctorDTO getDoctorDTO(Doctor Doctor);

    List<PeopleDTO> getPeopleDTO(List<People> peoples);

    List<VaccineDTO> getVaccineDTO(List<Vaccine> vaccines);

    List<DoctorDTO> getDoctorDTO(List<Doctor> doctors);

}
