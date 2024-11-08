package com.arkdev.filmx.controller;

import com.arkdev.filmx.model.Genre;
import com.arkdev.filmx.model.Movie;
import com.arkdev.filmx.service.is.IGenreService;
import com.arkdev.filmx.service.is.IMovieService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AdminController {
    IGenreService genreService;
    IMovieService movieService;

    @GetMapping("/home")
    public String homePage() {
        return "admin/pages/home";
    }

    @GetMapping("/genre")
    public String genrePage(Model model) {
        model.addAttribute("genres", genreService.getAllGenres());
        return "admin/pages/genre/genre-list";
    }

    @GetMapping("/genre/add")
    public String genreAddPage() {
        return "admin/pages/genre/add-genre";
    }

    @PostMapping("/genre/update")
    public String genreUpdatePage(Model model, @RequestParam Integer genreId) {
        Genre genre = genreService.getGenreById(genreId);
        model.addAttribute("genre", genre);
        return "admin/pages/genre/update-genre";
    }

    @GetMapping("/movie")
    public String moviePage(Model model) {
        model.addAttribute("movies", movieService.getAllMovies());
        return "admin/pages/movies/movie-list";
    }

    @GetMapping("/movie/details")
    public String movieDetailPage(Model model, @RequestParam Long movieId) {
        Movie movie = movieService.getMovieById(movieId);
        model.addAttribute("movie", movie);
        return "admin/pages/movies/movie-details";
    }

    @GetMapping("/movie/add")
    public String movieAddPage(Model model) {
        List<Genre> genres = genreService.getAllGenres();
        model.addAttribute("genres", genres);
        return "admin/pages/movies/add-movie";
    }

    @PostMapping("/movie/update")
    public String movieUpdatePage(Model model, @RequestParam Long movieId) {
        Movie movie = movieService.getMovieById(movieId);
        model.addAttribute("movie", movie);
        return "admin/pages/movies/update-movie";
    }

    @GetMapping("/episode/add")
    public String episodeAddPage(Model model, @RequestParam Long movieId) {
        model.addAttribute("movieId", movieId);
        return "admin/pages/episodes/add-episode";
    }
}
