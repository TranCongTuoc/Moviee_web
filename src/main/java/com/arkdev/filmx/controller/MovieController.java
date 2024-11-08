package com.arkdev.filmx.controller;

import com.arkdev.filmx.dto.request.MovieRequest;
import com.arkdev.filmx.model.Movie;
import com.arkdev.filmx.service.is.IMovieService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Validated
public class MovieController {
    IMovieService movieService;

    @GetMapping("/view")
    public ResponseEntity<?> getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addMovie(@RequestBody @Validated MovieRequest request,
                                      @RequestParam Integer genreId) {
        movieService.insertMovie(request, genreId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateMovie(@RequestBody @Validated MovieRequest request,
                                         @RequestParam Long movieId,
                                         @RequestParam Integer genreId) {
        movieService.updateMovie(request, movieId, genreId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteMovie(@RequestParam Long movieId) {
        movieService.deleteMovie(movieId);
        return ResponseEntity.ok().build();
    }
}
