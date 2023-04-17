package com.gabe.peopleManagement.services;

import com.gabe.peopleManagement.dtos.address.AddressResponseDTO;
import com.gabe.peopleManagement.entities.Address;
import com.gabe.peopleManagement.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AddressServices {

  @Autowired
  private AddressRepository addressRepository;


  public AddressResponseDTO create(Address address) {
    return new AddressResponseDTO(addressRepository.save(address));
  }

  public List<AddressResponseDTO> findAllByOwnerId(String uuid) {
    return addressRepository.findAllByOwner_Id(UUID.fromString(uuid))
            .stream().map(AddressResponseDTO::new).toList();
  }

  public AddressResponseDTO findPrimaryAddressByOwnerId(String uuid) {
    return new AddressResponseDTO(addressRepository.findFirstByOwner_IdAndIsPrimaryIsTrue(UUID.fromString(uuid)));
  }

  public AddressRepository getAddressRepository() {
    return addressRepository;
  }

}
