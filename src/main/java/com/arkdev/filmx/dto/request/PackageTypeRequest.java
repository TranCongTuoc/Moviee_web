package com.arkdev.filmx.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PackageTypeRequest(
        @NotNull(message = "Package name must be not null")
        @NotBlank(message = "Package name must be not blank")
        String packageName,
        String description,
        @NotNull(message = "Price must be not null")
        @NotBlank(message = "Price must be not blank")
        Double price,
        @NotNull(message = "Duration must be not null")
        @NotBlank(message = "Duration name must be not blank")
        Integer duration
) {
}
