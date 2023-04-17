package com.gabe.peopleManagement.dtos.address;

import com.gabe.peopleManagement.entities.Address;

public record AddressResponseDTO(String logradouro, String CEP, String city, int number, boolean isPrimary) {
    public AddressResponseDTO(Address address) {
        this(address.getLogradouro(), address.getCEP(),  address.getCity(), address.getNumber(), address.isPrimary());
    }
}
