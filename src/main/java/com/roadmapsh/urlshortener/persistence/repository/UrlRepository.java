package com.roadmapsh.urlshortener.persistence.repository;

import com.roadmapsh.urlshortener.persistence.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<Url, Long> {
    Optional<Url> findByShortCode(String shortCode);

    boolean existsByUrl(String originalUrl);
}
