package se331.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se331.rest.entity.People;
import se331.rest.service.PeopleService;
import se331.rest.util.LabMapper;

@Controller
public class PeopleController {

    @Autowired
    PeopleService peopleService;

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
}
