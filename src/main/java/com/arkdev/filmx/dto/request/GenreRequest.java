package com.arkdev.filmx.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record GenreRequest(
        @NotNull(message = "Genre name must be not null")
        @NotBlank(message = "Genre name must be not blank")
        String genreName
) {
}
