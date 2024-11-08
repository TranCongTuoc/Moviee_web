package com.arkdev.filmx.service;

import com.arkdev.filmx.dto.mapper.is.IEpisodeMapper;
import com.arkdev.filmx.dto.request.EpisodeRequest;
import com.arkdev.filmx.model.Episode;
import com.arkdev.filmx.model.Movie;
import com.arkdev.filmx.repository.EpisodeRepository;
import com.arkdev.filmx.repository.MovieRepository;
import com.arkdev.filmx.service.is.IEpisodeService;
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
public class EpisodeService implements IEpisodeService {
    EpisodeRepository episodeRepository;
    MovieRepository movieRepository;
    IEpisodeMapper episodeMapper;

    @Override
    public void insertEpisode(EpisodeRequest request, Long movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(
                () -> new RuntimeException("Movie not found"));
        Episode episode = episodeMapper.toEpisode(request);
        episode.setMovie(movie);
        episodeRepository.save(episode);
        log.info("Episode inserted: {}", episode);
    }

    @Override
    public void updateEpisode(EpisodeRequest request, Long episodeId, Long movieId) {
        Episode episode = episodeRepository.findById(episodeId).orElseThrow(
                () -> new IllegalArgumentException("Episode not found")
        );
        Movie movie = movieRepository.findById(movieId).orElseThrow(
                () -> new RuntimeException("Movie not found"));
        episodeMapper.updateEpisode(request, episode);
        episode.setMovie(movie);
        episodeRepository.save(episode);
        log.info("Episode updated: {}", episode);
    }

    @Override
    public void deleteEpisode(Long episodeId) {
        episodeRepository.deleteById(episodeId);
        log.info("Episode deleted: {}", episodeId);
    }

    @Override
    public Episode getEpisode(Long episodeId) {
        return episodeRepository.findById(episodeId).orElseThrow(
                () -> new IllegalArgumentException("Episode not found")
        );
    }

    @Override
    public List<Episode> getAllEpisodes() {
        return episodeRepository.findAll();
    }
}
