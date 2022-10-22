package se331.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.rest.entity.People;
import se331.rest.repository.PeopleRepository;

import javax.transaction.Transactional;

@Component
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    PeopleRepository peopleRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent){
        People tempPeople = null;
        tempPeople = People.builder()
                .name("aa")
                .surname("aa")
                .age("aa")
                .hometown("aa")
                .comment("aa")
                .build();
        peopleRepository.save(tempPeople);


    }
}
