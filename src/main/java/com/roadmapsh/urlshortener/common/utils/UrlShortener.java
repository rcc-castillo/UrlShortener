package com.roadmapsh.urlshortener.common.utils;

import java.util.UUID;

public class UrlShortener {
    public static String generateShortUrl() {
        return UUID.randomUUID().toString().substring(0, 6);
    }
}
