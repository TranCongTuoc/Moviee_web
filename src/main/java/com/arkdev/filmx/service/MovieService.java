package com.arkdev.filmx.service;

import com.arkdev.filmx.dto.mapper.is.IMovieMapper;
import com.arkdev.filmx.dto.request.MovieRequest;
import com.arkdev.filmx.model.Genre;
import com.arkdev.filmx.model.Movie;
import com.arkdev.filmx.repository.GenreRepository;
import com.arkdev.filmx.repository.MovieRepository;
import com.arkdev.filmx.service.is.IMovieService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class MovieService implements IMovieService {
    MovieRepository movieRepository;
    GenreRepository genreRepository;
    IMovieMapper movieMapper;

    @Override
    public void insertMovie(MovieRequest request, Integer genreId) {
        Movie movie = movieMapper.toMovie(request);
        Genre genre = genreRepository.findById(genreId).orElseThrow(
                () -> new IllegalArgumentException("Genre not found")
        );
        movieMapper.updateMovie(movie, request);
        movie.setGenre(genre);
        movieRepository.save(movie);
        log.info("Inserted movie: {}", movie);
    }
    @Override
    public void updateMovie(MovieRequest request, Long movieId, Integer genreId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(
                () -> new IllegalArgumentException("Movie not found")
        );
        Genre genre = genreRepository.findById(genreId).orElseThrow(
                () -> new IllegalArgumentException("Genre not found")
        );
        movieMapper.updateMovie(movie, request);
        movie.setGenre(genre);
        movieRepository.save(movie);
        log.info("Updated movie: {}", movie);
    }

    @Override
    public void deleteMovie(Long movieId) {
        movieRepository.deleteById(movieId);
        log.info("Deleted movie: {}", movieId);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(Long movieId) {
        return movieRepository.findById(movieId).orElseThrow(
                () -> new RuntimeException("Movie not found")
        );
    }
}
