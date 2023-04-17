package com.gabe.peopleManagement.dtos.address;

import org.springframework.lang.Nullable;

public record AddressUpdateRequestDTO(@Nullable String address, @Nullable String CEP, @Nullable String number, @Nullable String city, @Nullable  String isPrimary) {

}
