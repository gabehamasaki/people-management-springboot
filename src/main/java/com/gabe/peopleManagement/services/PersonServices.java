package com.gabe.peopleManagement.services;

import com.gabe.peopleManagement.dtos.person.PersonRequestDTO;
import com.gabe.peopleManagement.dtos.person.PersonResponseDTO;
import com.gabe.peopleManagement.entities.Person;
import com.gabe.peopleManagement.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonServices {

  @Autowired
  private PersonRepository personRepository;

  public PersonResponseDTO create(PersonRequestDTO data) {
    Person person = personRepository.save(new Person(data));
    return new PersonResponseDTO(person.getId(), person.getName(), person.getDate_of_birth());
  }

  public PersonResponseDTO update(String uuid, PersonRequestDTO data) {
    Person person = findPersonById(uuid);

    person.setName(data.name() != null ? data.name() : person.getName());
    person.setDate_of_birth(data.date_of_birth() != null ? data.date_of_birth() : person.getDate_of_birth());

    personRepository.save(person);
    return new PersonResponseDTO(person.getId(), person.getName(), person.getDate_of_birth());
  }

  public List<PersonResponseDTO> findAll() {
    return personRepository.findAll().stream().map(PersonResponseDTO::new).toList();
  }

  public Person findPersonById(String id) {
    return personRepository.findById(UUID.fromString(id)).orElse(null);
  }

  public PersonRepository getPersonRepository() {
    return personRepository;
  }
}
