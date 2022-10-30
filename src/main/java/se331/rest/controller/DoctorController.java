package se331.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;
import se331.rest.entity.Doctor;
import se331.rest.entity.People;
import se331.rest.security.dao.UserDao;
import se331.rest.security.entity.Authority;
import se331.rest.security.entity.AuthorityName;
import se331.rest.security.entity.User;
import se331.rest.security.repository.AuthorityRepository;
import se331.rest.security.repository.UserRepository;
import se331.rest.service.DoctorService;
import se331.rest.util.LabMapper;

@Controller
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @Autowired
    UserDao userDao;

    @Autowired
    AuthorityRepository authorityRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("doctor/{id}")
    public ResponseEntity<?> getDoctor(@PathVariable("id") Long id){
        Doctor output = doctorService.getDoctor(id);
        if (output != null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getDoctorDTO(output));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");
        }
    }

    @PostMapping("/applyDoctor")
    public ResponseEntity<?> applyDoctor(@RequestBody User user) throws AuthenticationException {
        User tempUser = userDao.findByID(user.getId()).orElse(null);
        Authority authDoctor = Authority.builder().name(AuthorityName.ROLE_DOCTOR).build();
        authorityRepository.save(authDoctor);
        tempUser.getAuthorities().clear();
        tempUser.getAuthorities().add(authDoctor);
        Doctor appD = Doctor.builder().name(tempUser.getFirstname())
                .surname(tempUser.getLastname())
                .user(userDao.findByID(user.getId()).orElse(null))
                .build();
        userRepository.save(tempUser);
        tempUser.setDoctor(appD);
        doctorService.save(appD);

        return ResponseEntity.ok(LabMapper.INSTANCE.getDoctorDTO(appD));
    }

    @GetMapping("doctorAll")
    ResponseEntity<?> getDoctorLists() {
        return ResponseEntity.ok(LabMapper.INSTANCE.getDoctorDTO(doctorService.getAllDoctor()));
    }
}
