package com.arkdev.filmx.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record EpisodeRequest (
        @NotNull(message = "Episode must be not null")
        @NotBlank(message = "Episode must be not blank")
        String episode,
        @NotNull(message = "Title must be not null")
        String title,
        Date releaseDate,
        Integer duration,
        @NotNull(message = "Video must be not null")
        @NotBlank(message = "Video must be not blank")
        String videoUrl
) {
}
