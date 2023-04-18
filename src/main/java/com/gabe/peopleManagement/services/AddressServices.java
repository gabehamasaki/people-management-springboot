package com.gabe.peopleManagement.services;

import com.gabe.peopleManagement.dtos.address.AddressResponseDTO;
import com.gabe.peopleManagement.dtos.address.AddressUpdateRequestDTO;
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

  public AddressResponseDTO update(Long id, AddressUpdateRequestDTO data) {

    if (addressRepository.findById(id).isEmpty()) return null;

    Address address = addressRepository.findById(id).get();

    address.setLogradouro(data.address() != null ? data.address() : address.getLogradouro());
    address.setCEP(data.CEP() != null ? data.CEP() : address.getCEP());
    address.setNumber(data.number() != null ? Integer.parseInt(data.number()) : address.getNumber());
    address.setCity(data.city() != null ? data.city() : address.getCity());
    address.setPrimary(data.isPrimary() != null ? Boolean.parseBoolean(data.isPrimary()): address.isPrimary());


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
