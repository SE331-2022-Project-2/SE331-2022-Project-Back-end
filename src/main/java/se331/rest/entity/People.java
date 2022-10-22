package se331.rest.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String name;
    String surname;
   // List<Vaccine> vaccineList;
    String age;
    String hometown;
    String comment;

    @OneToMany(mappedBy = "patient")
    @Builder.Default
    List<Vaccine> hasVaccines = new ArrayList<>();

    @ElementCollection
    List<String> imageUrls;
}
