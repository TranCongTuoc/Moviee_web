package com.arkdev.filmx.dto.mapper;

import com.arkdev.filmx.dto.mapper.is.IGenreMapper;
import com.arkdev.filmx.dto.request.GenreRequest;
import com.arkdev.filmx.model.Genre;
import org.springframework.stereotype.Component;

@Component
public class GenreMapper implements IGenreMapper {
    @Override
    public Genre toGenre(GenreRequest request) {
        if (request == null) {
            return null;
        } else {
            Genre.GenreBuilder genre = Genre.builder();
            genre.genreName(request.genreName());
            return genre.build();
        }
    }
    @Override
    public void updateGenre(Genre genre, GenreRequest request) {
        if (request != null) {
            genre.setGenreName(request.genreName());
        }
    }
}
