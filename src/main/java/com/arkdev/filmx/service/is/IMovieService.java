package com.arkdev.filmx.service.is;

import com.arkdev.filmx.dto.request.MovieRequest;
import com.arkdev.filmx.model.Movie;

import java.util.List;

public interface IMovieService {
    void insertMovie(MovieRequest request, Integer genreId);

    void updateMovie(MovieRequest request, Long movieId, Integer genreId);

    void deleteMovie(Long movieId);

    List<Movie> getAllMovies();

    Movie getMovieById(Long movieId);
}
