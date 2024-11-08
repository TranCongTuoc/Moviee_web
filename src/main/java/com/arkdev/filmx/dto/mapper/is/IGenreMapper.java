package com.arkdev.filmx.dto.mapper.is;

import com.arkdev.filmx.dto.request.GenreRequest;
import com.arkdev.filmx.model.Genre;

public interface IGenreMapper {
    Genre toGenre(GenreRequest request);
    void updateGenre(Genre genre, GenreRequest request);
}
