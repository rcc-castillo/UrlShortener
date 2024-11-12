package com.roadmapsh.urlshortener.bussiness.service;

import com.roadmapsh.urlshortener.common.dto.UrlStatsDTO;
import com.roadmapsh.urlshortener.common.exceptions.InvalidUrlException;
import com.roadmapsh.urlshortener.common.exceptions.ShortCodeNotFoundException;
import com.roadmapsh.urlshortener.common.exceptions.UrlAlreadyExistsException;
import com.roadmapsh.urlshortener.common.utils.UrlShortener;
import com.roadmapsh.urlshortener.common.utils.UrlValidator;
import com.roadmapsh.urlshortener.persistence.model.Url;
import com.roadmapsh.urlshortener.persistence.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UrlShortenerServiceImpl implements UrlShortenerService {

    private final UrlRepository urlRepository;

    @Autowired
    public UrlShortenerServiceImpl(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Override
    @Transactional
    public Url createShortUrl(String originalUrl) {
        if (!UrlValidator.isValidUrl(originalUrl)) throw new InvalidUrlException("La URL no es válida");
        if (urlRepository.existsByUrl(originalUrl)) throw new UrlAlreadyExistsException("La URL ya existe");
        String shortUrl = UrlShortener.generateShortUrl();
        Url url = new Url();
        url.setUrl(originalUrl);
        url.setShortCode(shortUrl);
        url.setCreatedDate(LocalDateTime.now());
        url.setUpdatedDate(LocalDateTime.now());
        return urlRepository.save(url);
    }

    @Override
    @Transactional
    public Optional<Url> getOriginalUrl(String shortUrl) {
        Optional<Url> url = urlRepository.findByShortCode(shortUrl);
        if (url.isEmpty()) throw new ShortCodeNotFoundException("ShortCode no encontrado");
        Url existingUrl = url.get();
        existingUrl.setAccessCount(existingUrl.getAccessCount() + 1);
        urlRepository.save(existingUrl);
        return Optional.of(existingUrl);
    }

    @Override
    @Transactional
    public Url updateShortUrl(String shortUrl, String newUrl) {
        if (!UrlValidator.isValidUrl(newUrl)) throw new InvalidUrlException("La URL no es válida");
        Optional<Url> url = urlRepository.findByShortCode(shortUrl);
        if (url.isEmpty()) throw new ShortCodeNotFoundException("ShortCode no encontrado");

        Url existingUrl = url.get();
        existingUrl.setUrl(newUrl);
        existingUrl.setUpdatedDate(LocalDateTime.now());
        urlRepository.save(existingUrl);
        return urlRepository.save(existingUrl);
    }

    @Override
    @Transactional
    public void deleteUrl(String shortUrl) {
        Optional<Url> url = urlRepository.findByShortCode(shortUrl);
        if (url.isEmpty()) throw new ShortCodeNotFoundException("ShortCode no encontrado");
        urlRepository.delete(url.get());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UrlStatsDTO> getUrlStats(String shortUrl) {
        Optional<Url> url = urlRepository.findByShortCode(shortUrl);
        if (url.isEmpty()) throw new ShortCodeNotFoundException("ShortCode no encontrado");
        Url existingUrl = url.get();
        UrlStatsDTO urlStatsDTO = new UrlStatsDTO(
                existingUrl.getId(),
                existingUrl.getUrl(),
                existingUrl.getShortCode(),
                existingUrl.getCreatedDate(),
                existingUrl.getUpdatedDate(),
                existingUrl.getAccessCount());
        return Optional.of(urlStatsDTO);
    }
}
