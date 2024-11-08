package com.arkdev.filmx.service.is;

import com.arkdev.filmx.dto.request.GenreRequest;
import com.arkdev.filmx.model.Genre;

import java.util.List;

public interface IGenreService {
    void insertGenre(GenreRequest request);

    void updateGenre(Integer genreId, GenreRequest request);

    void deleteGenre(Integer genreId);

    List<Genre> getAllGenres();

    Genre getGenreById(Integer genreId);
}
