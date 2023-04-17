package com.gabe.peopleManagement.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.gabe.peopleManagement.dtos.address.AddressRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "address")
@Entity(name = "address")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Address {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private String CEP;
    private int number;
    private String city;

    private boolean isPrimary;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person owner;

    public Address(AddressRequestDTO data, Person owner) {
        this.logradouro = data.address();
        this.CEP = data.CEP();
        this.number = data.number();
        this.city = data.city();
        this.isPrimary = data.isPrimary();
        this.owner = owner;
    }

}
