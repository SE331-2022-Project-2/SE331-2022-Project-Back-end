package se331.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import se331.rest.service.VaccineService;
import se331.rest.util.LabMapper;

@Controller
public class VaccineController {
    @Autowired
    VaccineService vaccineService;

    @GetMapping("/vaccines")
    ResponseEntity<?> getVaccines() {
        return ResponseEntity.ok(LabMapper.INSTANCE.getVaccineDTO(vaccineService.getAllVaccine()));
    }
}
