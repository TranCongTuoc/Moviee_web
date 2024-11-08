package com.arkdev.filmx.service.is;

import com.arkdev.filmx.dto.request.EpisodeRequest;
import com.arkdev.filmx.model.Episode;

import java.util.List;

public interface IEpisodeService {
    void insertEpisode(EpisodeRequest request, Long movieId);

    void updateEpisode(EpisodeRequest request, Long episodeId, Long movieId);

    void deleteEpisode(Long episodeId);

    Episode getEpisode(Long episodeId);

    List<Episode> getAllEpisodes();
}
