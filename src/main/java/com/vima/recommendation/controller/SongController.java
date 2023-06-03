package com.vima.recommendation.controller;

import com.vima.recommendation.model.Song;
import com.vima.recommendation.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/song")
@RequiredArgsConstructor
public class SongController {

    private final SongRepository songRepository;

    @GetMapping("")
    public ResponseEntity<List<Song>> findAll(){
        return ResponseEntity.ok(songRepository.findAll());
    }
}
