package com.arkdev.filmx.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record MovieRequest (
        @NotNull(message = "Title must be not null")
        @NotBlank(message = "Title must be not blank")
        String title,
        @NotNull(message = "Description must be not null")
        String description,
        @NotNull(message = "Release Date must be not null")
        Date releaseDate,
        Integer duration,
        @NotNull(message = "Trailer must be not null")
        String trailer
) {
}
