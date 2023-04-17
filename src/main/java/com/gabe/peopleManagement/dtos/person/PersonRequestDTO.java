package com.gabe.peopleManagement.dtos.person;

import jakarta.annotation.Nullable;

public record PersonRequestDTO(@Nullable String name, @Nullable String date_of_birth) {
}
