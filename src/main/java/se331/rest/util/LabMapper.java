package se331.rest.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import se331.rest.entity.*;
import se331.rest.security.entity.User;
import se331.rest.security.entity.UserAuthDTO;

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

    @Mapping(target = "authorities", expression = "java(people.getUser().getAuthorities().stream().map(auth -> auth.getName().name()).collect(Collectors.toList()))")
    PeopleAuthDTO getPeopleAuthDTO(People people);

    @Mapping(target = "authorities", expression = "java(user.getAuthorities().stream().map(auth -> auth.getName().name()).collect(Collectors.toList()))")
    UserAuthDTO getUserAuthDTO(User user);
}
