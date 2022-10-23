package se331.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import se331.rest.entity.Doctor;
import se331.rest.entity.People;
import se331.rest.entity.Vaccine;
import se331.rest.repository.DoctorRepository;
import se331.rest.repository.PeopleRepository;
import se331.rest.repository.VaccineRepository;
import se331.rest.security.entity.Authority;
import se331.rest.security.entity.AuthorityName;
import se331.rest.security.entity.User;
import se331.rest.security.repository.AuthorityRepository;
import se331.rest.security.repository.UserRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

@Component
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    PeopleRepository peopleRepository;

    @Autowired
    VaccineRepository vaccineRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    AuthorityRepository authorityRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent){
        People people1 = People.builder()
                .name("Mia")
                .surname("Price")
                .age("39 years old")
                .hometown("63 Grand St. Moncks Corner, SC 29461")
                .comment(new ArrayList<>())
                .imageUrls(new ArrayList<>())
                .build();
        people1.getImageUrls().add("gs://imageupload-69268.appspot.com/31149f2bab58419ff1748883e6647dba.jpg");
        people1.getComment().add("Mia Price is in very good health.");
        peopleRepository.save(people1);

        People people2 = People.builder()
                .name("Daniel")
                .surname("Robinson")
                .age("23 years old")
                .hometown("51 Golden Star Dr. Huntington, NY 11743")
                .comment(new ArrayList<>())
                .imageUrls(new ArrayList<>())
                .build();
        people2.getImageUrls().add("gs://imageupload-69268.appspot.com/5141842f0bbe969e5cd7af615eed7a54.jpg");
        people2.getComment().add("Daniel Robinson has very bad health.");
        peopleRepository.save(people2);

        People people3 = People.builder()
                .name("Donald")
                .surname("Lewis")
                .age("29 years old")
                .hometown("52 Ryan Street. Sioux City, IA 51106")
                .comment(new ArrayList<>())
                .imageUrls(new ArrayList<>())
                .build();
        people3.getImageUrls().add("gs://imageupload-69268.appspot.com/659d4009a6059a2241cf73141f242db6.jpg");
        people3.getComment().add("Donald Lewis has very bad health");
        peopleRepository.save(people3);

        People people4 = People.builder()
                .name("Nathan")
                .surname("Simpson")
                .age("27 years old")
                .hometown("564 Argyle Road. Lithonia, GA 30038")
                .comment(new ArrayList<>())
                .imageUrls(new ArrayList<>())
                .build();
        people4.getImageUrls().add("gs://imageupload-69268.appspot.com/b306751818a4b8ccb0a681b294fc8a1c.jpg");
        people4.getComment().add("Nathan Simpson is in very good health.");
        peopleRepository.save(people4);

        People people5 = People.builder()
                .name("Thomas")
                .surname("Mitchell")
                .age("33 years old")
                .hometown("9892 Clark St. Pittsburgh, PA 15206")
                .comment(new ArrayList<>())
                .imageUrls(new ArrayList<>())
                .build();
        people5.getImageUrls().add("gs://imageupload-69268.appspot.com/d4e373b4d88b16004532ee8dab646b4c.jpg");
        people5.getComment().add("Thomas Mitchell is in very good health.");
        peopleRepository.save(people5);

        People people6 = People.builder()
                .name("Nathan")
                .surname("Jackson")
                .age("23 years old")
                .hometown("546 Arnold Drive. Port Washington, NY 11050")
                .comment(new ArrayList<>())
                .imageUrls(new ArrayList<>())
                .build();
        people6.getImageUrls().add("gs://imageupload-69268.appspot.com/f0411a5773d50fde980c68dea296faa3.jpg");
        people6.getComment().add("Nathan Jackson has very bad health.");
        peopleRepository.save(people6);

        Doctor doctor1 = Doctor.builder()
                .name("Emma")
                .surname("Edison")
                .build();
        doctorRepository.save(doctor1);

        Doctor doctor2 = Doctor.builder()
                .name("Watson")
                .surname("Bulder")
                .build();
        doctorRepository.save(doctor2);

        Doctor doctor3 = Doctor.builder()
                .name("Lucas")
                .surname("Vladilen")
                .build();
        doctorRepository.save(doctor3);

        Vaccine vac1 = Vaccine.builder()
                .vaccineName("Sinovac")
                .date("20 January 2022")
                .dose(1)
                .patient(people1)
                .doctor(doctor1)
                .build();
        vaccineRepository.save(vac1);
        people1.getHasVaccines().add(vac1);
        doctor1.getDoVaccines().add(vac1);

        Vaccine vac2 = Vaccine.builder()
                .vaccineName("Pfizer")
                .date("15 January 2022")
                .dose(1)
                .patient(people2)
                .doctor(doctor1)
                .build();
        vaccineRepository.save(vac2);
        people2.getHasVaccines().add(vac2);
        doctor1.getDoVaccines().add(vac2);

        Vaccine vac3 = Vaccine.builder()
                .vaccineName("Sinovac")
                .date("9 December 2021")
                .dose(1)
                .patient(people3)
                .doctor(doctor2)
                .build();
        vaccineRepository.save(vac3);
        people3.getHasVaccines().add(vac3);
        doctor2.getDoVaccines().add(vac3);

        Vaccine vac4 = Vaccine.builder()
                .vaccineName("Pfizer")
                .date("3 March 2022")
                .dose(2)
                .patient(people3)
                .doctor(doctor2)
                .build();
        vaccineRepository.save(vac4);
        people3.getHasVaccines().add(vac4);
        doctor2.getDoVaccines().add(vac4);

        Vaccine vac5 = Vaccine.builder()
                .vaccineName("Moderna")
                .date("3 January 2022")
                .dose(1)
                .patient(people4)
                .doctor(doctor2)
                .build();
        vaccineRepository.save(vac5);
        people4.getHasVaccines().add(vac5);
        doctor2.getDoVaccines().add(vac5);

        Vaccine vac6 = Vaccine.builder()
                .vaccineName("Pfizer")
                .date("24 April 2022")
                .dose(2)
                .patient(people4)
                .doctor(doctor2)
                .build();
        vaccineRepository.save(vac6);
        people4.getHasVaccines().add(vac6);
        doctor2.getDoVaccines().add(vac6);

        Vaccine vac7 = Vaccine.builder()
                .vaccineName("Moderna")
                .date("12 January 2022")
                .dose(1)
                .patient(people5)
                .doctor(doctor3)
                .build();
        vaccineRepository.save(vac7);
        people5.getHasVaccines().add(vac7);
        doctor3.getDoVaccines().add(vac7);

        Vaccine vac8 = Vaccine.builder()
                .vaccineName("Moderna")
                .date("1 April 2022")
                .dose(2)
                .patient(people5)
                .doctor(doctor3)
                .build();
        vaccineRepository.save(vac8);
        people5.getHasVaccines().add(vac8);
        doctor3.getDoVaccines().add(vac8);

        Vaccine vac9 = Vaccine.builder()
                .vaccineName("Sinovac")
                .date("10 October 2021")
                .dose(1)
                .patient(people6)
                .doctor(doctor3)
                .build();
        vaccineRepository.save(vac9);
        people6.getHasVaccines().add(vac9);
        doctor3.getDoVaccines().add(vac9);

        addUser();
    }

    User user1, user2, user3;
    private void addUser() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        Authority authUser = Authority.builder().name(AuthorityName.ROLE_USER).build();
        Authority authAdmin = Authority.builder().name(AuthorityName.ROLE_ADMIN).build();
        user1 = User.builder()
                .username("admin")
                .password(encoder.encode("admin"))
                .firstname("admin")
                .lastname("admin")
                .email("admin@admin.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        user2 = User.builder()
                .username("user")
                .password(encoder.encode("user"))
                .firstname("user")
                .lastname("user")
                .email("enabled@user.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        user3 = User.builder()
                .username("disableUser")
                .password(encoder.encode("disableUser"))
                .firstname("disableUser")
                .lastname("disableUser")
                .email("disableUser@user.com")
                .enabled(false)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        authorityRepository.save(authUser);
        authorityRepository.save(authAdmin);
        user1.getAuthorities().add(authUser);
        user1.getAuthorities().add(authAdmin);
        user2.getAuthorities().add(authUser);
        user3.getAuthorities().add(authUser);
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
    }
}
