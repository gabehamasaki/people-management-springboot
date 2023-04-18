package com.gabe.peopleManagement.dtos.person;

import jakarta.annotation.Nullable;

public record PersonRequestUpdateDTO(@Nullable String name, @Nullable String date_of_birth) {
}
