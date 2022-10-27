package se331.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se331.rest.entity.People;
import se331.rest.security.dao.UserDao;
import se331.rest.security.entity.Authority;
import se331.rest.security.entity.AuthorityName;
import se331.rest.security.entity.User;
import se331.rest.security.repository.AuthorityRepository;
import se331.rest.security.repository.UserRepository;
import se331.rest.security.service.UserService;
import se331.rest.service.PeopleService;
import se331.rest.util.LabMapper;

import java.util.List;

@Controller
public class PeopleController {

    @Autowired
    PeopleService peopleService;

    @Autowired
    UserDao userDao;

    @Autowired
    AuthorityRepository authorityRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("people")
    public ResponseEntity<?> getPeopleLists(@RequestParam(value = "_limit", required = false) Integer perPage
            , @RequestParam(value = "_page", required = false) Integer page) {
        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;
        Page<People> pageOutput;
        pageOutput = peopleService.getPeoples(perPage, page);
        HttpHeaders responseHeader = new HttpHeaders();

        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getPeopleDTO(pageOutput.getContent()), responseHeader , HttpStatus.OK);
    }

    @GetMapping("peopleAll")
    ResponseEntity<?> getPeopleLists() {
        return ResponseEntity.ok(LabMapper.INSTANCE.getPeopleDTO(peopleService.getAllPeople()));
    }

    @GetMapping("people/{id}")
    public ResponseEntity<?> getPeople(@PathVariable("id") Long id) {
        People output = peopleService.getPeople(id);
        if(output != null){
            return ResponseEntity.ok(LabMapper.INSTANCE.getPeopleDTO(output));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");
        }
    }

    @PostMapping("/people")
    public ResponseEntity<?> addPeople(@RequestBody People people) {
        People output = peopleService.save(people);
        return ResponseEntity.ok(LabMapper.INSTANCE.getPeopleDTO(output));
    }

    @PostMapping("/comment/{id}")
    public ResponseEntity<?> addComment(@PathVariable("id") Long id, @RequestBody String newComment) {
        People tempPeople = peopleService.getPeople(id);
        tempPeople.getComment().add(newComment);
        peopleService.save(tempPeople);
        return ResponseEntity.ok(LabMapper.INSTANCE.getPeopleDTO(tempPeople));
    }

    @PostMapping("/applyPeople")
    public ResponseEntity<?> applyPeople(@RequestBody User user) throws AuthenticationException {
        User tempUser = userDao.findByID(user.getId()).orElse(null);
        Authority authPeople = Authority.builder().name(AuthorityName.ROLE_PEOPLE).build();
        authorityRepository.save(authPeople);
        tempUser.getAuthorities().add(authPeople);
        People appP = People.builder().name(tempUser.getFirstname())
                .surname(tempUser.getLastname())
                .age(tempUser.getAge())
                .hometown(tempUser.getHometown())
                .user(userDao.findByID(user.getId()).orElse(null))
                .build();
        userRepository.save(tempUser);
        tempUser.setPeople(appP);
        peopleService.save(appP);

        return ResponseEntity.ok(LabMapper.INSTANCE.getPeopleDTO(appP));
    }
}
