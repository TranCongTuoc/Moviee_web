package com.arkdev.filmx.service;

import com.arkdev.filmx.dto.mapper.is.IGenreMapper;
import com.arkdev.filmx.dto.request.GenreRequest;
import com.arkdev.filmx.model.Genre;
import com.arkdev.filmx.repository.GenreRepository;
import com.arkdev.filmx.service.is.IGenreService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GenreService implements IGenreService {
    GenreRepository genreRepository;
    IGenreMapper genreMapper;

    @Override
    public void insertGenre(GenreRequest request) {
        Genre genre = genreMapper.toGenre(request);
        genreRepository.save(genre);
        log.info("Inserted genre: {}", genre.getGenreId());
    }

    @Override
    public void updateGenre(Integer genreId, GenreRequest request) {
        Genre genre = genreRepository.findById(genreId).orElseThrow(
                () -> new RuntimeException("Genre not found")
        );
        genreMapper.updateGenre(genre, request);
        genreRepository.save(genre);
        log.info("Updated genre: {}", genre);
    }

    @Override
    public void deleteGenre(Integer genreId) {
        genreRepository.deleteById(genreId);
        log.info("Deleted genre: {}", genreId);
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public Genre getGenreById(Integer genreId) {
        return genreRepository.findById(genreId).orElseThrow(
                () -> new RuntimeException("Genre not found"));
    }
}
