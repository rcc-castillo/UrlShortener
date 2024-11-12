package com.roadmapsh.urlshortener.presentation.controller;

import com.roadmapsh.urlshortener.bussiness.service.UrlShortenerService;
import com.roadmapsh.urlshortener.common.dto.UrlStatsDTO;
import com.roadmapsh.urlshortener.persistence.model.Url;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UrlShortenerController {
    private final UrlShortenerService urlShortenerService;

    @Autowired
    public UrlShortenerController(UrlShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }

    @PostMapping("/shorten")
    public ResponseEntity<Url> createShortUrl(@Valid @RequestBody Url url) {
        Url shortUrl = urlShortenerService.createShortUrl(url.getUrl());
        return ResponseEntity.status(HttpStatus.CREATED).body(shortUrl);
    }

    @GetMapping("/shorten/{shortUrl}")
    public ResponseEntity<Url> getOriginalUrl(@PathVariable String shortUrl) {
        Url originalUrl = urlShortenerService.getOriginalUrl(shortUrl).orElseThrow();
        return ResponseEntity.ok(originalUrl);
    }

    @PutMapping("/shorten/{shortUrl}")
    public ResponseEntity<Url> updateShortUrl(@PathVariable String shortUrl, @Valid @RequestBody Url url) {
        Url updatedUrl = urlShortenerService.updateShortUrl(shortUrl, url.getUrl());
        return ResponseEntity.ok(updatedUrl);
    }

    @DeleteMapping("/shorten/{shortUrl}")
    public ResponseEntity<Void> deleteUrl(@PathVariable String shortUrl) {
        urlShortenerService.deleteUrl(shortUrl);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/shorten/{shortUrl}/stats")
    public ResponseEntity<UrlStatsDTO> getUrlStats(@PathVariable String shortUrl) {
        UrlStatsDTO urlStats = urlShortenerService.getUrlStats(shortUrl).orElseThrow();
        return ResponseEntity.ok(urlStats);
    }
}
