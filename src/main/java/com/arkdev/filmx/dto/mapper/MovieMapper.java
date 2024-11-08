package com.arkdev.filmx.dto.mapper;

import com.arkdev.filmx.dto.mapper.is.IMovieMapper;
import com.arkdev.filmx.dto.request.MovieRequest;
import com.arkdev.filmx.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper implements IMovieMapper {
    @Override
    public Movie toMovie(MovieRequest request) {
        if (request == null) {
            return null;
        } else {
            Movie.MovieBuilder movie = Movie.builder();
            return movie.title(request.title())
                    .description(request.description())
                    .releaseDate(request.releaseDate())
                    .duration(request.duration())
                    .trailer(request.trailer())
                    .build();
        }
    }

    @Override
    public void updateMovie(Movie movie, MovieRequest request) {
        if (request != null) {
            movie.setTitle(request.title());
            movie.setDescription(request.description());
            movie.setReleaseDate(request.releaseDate());
            movie.setDuration(request.duration());
            movie.setTrailer(request.trailer());
        }
    }
}
