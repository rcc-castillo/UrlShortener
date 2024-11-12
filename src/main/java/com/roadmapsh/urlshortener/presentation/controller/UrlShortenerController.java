package com.roadmapsh.urlshortener.presentation.controller;

import com.roadmapsh.urlshortener.bussiness.service.UrlShortenerService;
import com.roadmapsh.urlshortener.common.dto.UrlStatsDTO;
import com.roadmapsh.urlshortener.persistence.model.Url;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UrlShortenerController {
    private final UrlShortenerService urlShortenerService;

    @Autowired
    public UrlShortenerController(UrlShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }

    @PostMapping
    public ResponseEntity<Url> createShortUrl(@Valid @RequestBody Url url) {
        Url shortUrl = urlShortenerService.createShortUrl(url.getUrl());
        return ResponseEntity.status(HttpStatus.CREATED).body(shortUrl);
    }
}
