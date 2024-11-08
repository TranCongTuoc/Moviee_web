package com.arkdev.filmx.controller;

import com.arkdev.filmx.dto.request.GenreRequest;
import com.arkdev.filmx.model.Genre;
import com.arkdev.filmx.service.is.IGenreService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genre")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GenreController {
    IGenreService genreService;

    @GetMapping("/view")
    public ResponseEntity<?> getAllGenres() {
        List<Genre> genres = genreService.getAllGenres();
        return ResponseEntity.ok(genres);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addGenre(@RequestBody @Validated GenreRequest request) {
        genreService.insertGenre(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateGenre(@RequestParam Integer genreId,
                                         @RequestBody @Validated GenreRequest request) {
        genreService.updateGenre(genreId, request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteGenre(@RequestParam Integer genreId) {
        genreService.deleteGenre(genreId);
        return ResponseEntity.ok().build();
    }
}
