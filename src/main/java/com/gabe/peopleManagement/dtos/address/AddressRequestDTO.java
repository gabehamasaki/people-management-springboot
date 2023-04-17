package com.gabe.peopleManagement.dtos.address;

public record AddressRequestDTO(String address, String CEP, int number, String city, boolean isPrimary) {

}
