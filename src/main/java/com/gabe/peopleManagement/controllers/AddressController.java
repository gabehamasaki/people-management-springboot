package com.gabe.peopleManagement.controllers;

import com.gabe.peopleManagement.dtos.address.AddressRequestDTO;
import com.gabe.peopleManagement.dtos.address.AddressResponseDTO;
import com.gabe.peopleManagement.entities.Address;
import com.gabe.peopleManagement.entities.Person;
import com.gabe.peopleManagement.services.AddressServices;
import com.gabe.peopleManagement.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("addresses")
public class AddressController {

  @Autowired
  private AddressServices addressServices;

  @Autowired
  private PersonServices personServices;

  @GetMapping("/{uuid}")
  public List<AddressResponseDTO> getAddresses(@PathVariable("uuid") String uuid) {
    return addressServices.findAllByOwnerId(uuid);
  }

  @GetMapping("/{uuid}/primary")
  public AddressResponseDTO getPrimaryAddress(@PathVariable("uuid") String uuid) {
    return addressServices.findPrimaryAddressByOwnerId(uuid);
  }


  @PostMapping("/{uuid}")
  public AddressResponseDTO addAddress(@PathVariable("uuid") String uuid, @RequestBody AddressRequestDTO data) {
    Person owner = personServices.findPersonById(uuid);
    Address address = new Address(data, owner);

    return addressServices.create(address);
  }


}
