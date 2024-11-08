package com.arkdev.filmx.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LoginRequest(
        @NotNull(message = "Login must be not null")
        @NotBlank(message = "Login must be not blank")
        String username,
        @NotNull(message = "Login must be not null")
        String password
) {
}
