package se331.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.rest.entity.People;
import se331.rest.entity.Vaccine;
import se331.rest.repository.PeopleRepository;
import se331.rest.repository.VaccineRepository;

import javax.transaction.Transactional;

@Component
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    PeopleRepository peopleRepository;

    @Autowired
    VaccineRepository vaccineRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent){
        People people1 = People.builder()
                .name("aa")
                .surname("aa")
                .age("aa")
                .hometown("aa")
                .comment("aa")
                .build();
        peopleRepository.save(people1);

        Vaccine vac1 = Vaccine.builder()
                .vaccineName("Sinovac")
                .date(" 21 AUG 2022")
                .dose(1)
                .patient(people1)
                .build();
        vaccineRepository.save(vac1);
        people1.getHasVaccines().add(vac1);

        Vaccine vac2 = Vaccine.builder()
                .vaccineName("Moderna")
                .date(" 25 SEP 2022")
                .dose(2)
                .patient(people1)
                .build();
        vaccineRepository.save(vac2);
    }
}
