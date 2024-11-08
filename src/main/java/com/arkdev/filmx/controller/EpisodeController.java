package com.arkdev.filmx.controller;

import com.arkdev.filmx.dto.request.EpisodeRequest;
import com.arkdev.filmx.model.Episode;
import com.arkdev.filmx.service.UploadService;
import com.arkdev.filmx.service.is.IEpisodeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/episode")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EpisodeController {
    IEpisodeService episodeService;
    UploadService uploadService;

    @GetMapping("/")
    public ResponseEntity<?> getAllEpisodes() {
        List<Episode> list = episodeService.getAllEpisodes();
        return ResponseEntity.ok(list);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addEpisode(@RequestParam String episode,
                                        @RequestParam String title,
                                        @RequestParam Integer duration,
                                        @RequestParam("releaseDate") String releaseDateStr,
                                        @RequestParam Long movieId,
                                        @RequestParam MultipartFile movieFile) throws IOException, ParseException {
        String videoUrl = uploadService.uploadVideo(movieFile);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date releaseDate = formatter.parse(releaseDateStr);
        EpisodeRequest request = new EpisodeRequest(episode, title, releaseDate, duration, videoUrl);
        episodeService.insertEpisode(request, movieId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateEpisode(@RequestBody @Validated EpisodeRequest request,
                                           @RequestParam Long episodeId,
                                           @RequestParam Long movieId) {
        episodeService.updateEpisode(request, episodeId, movieId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteEpisode(@RequestParam Long episodeId) {
        episodeService.deleteEpisode(episodeId);
        return ResponseEntity.ok().build();
    }
}
