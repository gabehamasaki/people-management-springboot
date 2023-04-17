package com.gabe.peopleManagement.dtos.person;

import com.gabe.peopleManagement.entities.Address;
import com.gabe.peopleManagement.entities.Person;

import java.util.List;
import java.util.UUID;

public record PersonResponseDTO(UUID uuid, String name, String date_of_birth) {
    public PersonResponseDTO(Person person) {
        this(person.getId(), person.getName(), person.getDate_of_birth());
    }
}
