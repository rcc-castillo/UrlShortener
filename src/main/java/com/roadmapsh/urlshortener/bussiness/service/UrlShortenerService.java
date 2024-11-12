package com.roadmapsh.urlshortener.bussiness.service;

import com.roadmapsh.urlshortener.common.dto.UrlStatsDTO;
import com.roadmapsh.urlshortener.persistence.model.Url;

import java.util.Optional;

public interface UrlShortenerService {
    Url createShortUrl(String originalUrl);
    Optional<Url> getOriginalUrl(String shortUrl);

    Url updateShortUrl(String shortUrl, String newUrl);

    void deleteUrl(String shortUrl);

    Optional<UrlStatsDTO> getUrlStats(String shortUrl);
}
