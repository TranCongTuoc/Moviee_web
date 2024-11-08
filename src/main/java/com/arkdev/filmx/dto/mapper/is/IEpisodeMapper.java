package com.arkdev.filmx.dto.mapper.is;

import com.arkdev.filmx.dto.request.EpisodeRequest;
import com.arkdev.filmx.model.Episode;

public interface IEpisodeMapper {
    Episode toEpisode(EpisodeRequest request);
    void updateEpisode(EpisodeRequest request, Episode episode);
}
