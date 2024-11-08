package com.arkdev.filmx.dto.mapper.is;

import com.arkdev.filmx.dto.request.MovieRequest;
import com.arkdev.filmx.model.Movie;

public interface IMovieMapper {
    Movie toMovie(MovieRequest request);
    void updateMovie(Movie movie, MovieRequest request);
}
