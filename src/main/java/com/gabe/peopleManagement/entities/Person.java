package com.gabe.peopleManagement.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.gabe.peopleManagement.dtos.person.PersonRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Table(name = "person")
@Entity(name = "person")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Person {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    private String date_of_birth;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private List<Address> addresses;

    public Person(PersonRequestDTO data) {
        this.name = data.name();
        this.date_of_birth = data.date_of_birth();
        this.addresses = new ArrayList<>();
    }

}
