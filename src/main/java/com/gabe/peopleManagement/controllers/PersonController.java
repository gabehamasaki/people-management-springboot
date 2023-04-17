package com.gabe.peopleManagement.controllers;

import com.gabe.peopleManagement.dtos.person.PersonRequestDTO;
import com.gabe.peopleManagement.dtos.person.PersonResponseDTO;
import com.gabe.peopleManagement.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    private PersonServices personServices;

    @GetMapping
    public List<PersonResponseDTO> getAll() {
        return personServices.findAll();
    }

    @PatchMapping("/{uuid}")
    public PersonResponseDTO updatePerson(@RequestBody PersonRequestDTO data, @PathVariable("uuid") String uuid){
        return personServices.update(uuid, data);
    }

    @PostMapping
    public PersonResponseDTO createPerson(@RequestBody PersonRequestDTO data) {
        return personServices.create(data);
    }
}
