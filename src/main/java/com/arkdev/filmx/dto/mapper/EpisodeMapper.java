package com.arkdev.filmx.dto.mapper;

import com.arkdev.filmx.dto.mapper.is.IEpisodeMapper;
import com.arkdev.filmx.dto.request.EpisodeRequest;
import com.arkdev.filmx.model.Episode;
import org.springframework.stereotype.Component;

@Component
public class EpisodeMapper implements IEpisodeMapper {

    @Override
    public Episode toEpisode(EpisodeRequest request) {
        if (request == null) {
            return null;
        } else {
            Episode.EpisodeBuilder episode = Episode.builder();
            episode.episode(request.episode());
            episode.title(request.title());
            episode.duration(request.duration());
            episode.videoUrl(request.videoUrl());
            episode.releaseDate(request.releaseDate());
            return episode.build();
        }
    }

    @Override
    public void updateEpisode(EpisodeRequest request, Episode episode) {
        if (request != null) {
            episode.setEpisode(request.episode());
            episode.setTitle(request.title());
            episode.setDuration(request.duration());
            episode.setVideoUrl(request.videoUrl());
            episode.setReleaseDate(request.releaseDate());
        }
    }
}
