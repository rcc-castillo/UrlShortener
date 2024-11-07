package com.roadmapsh.urlshortener.common.utils;

import java.net.URI;
import java.net.URISyntaxException;

public class UrlValidator {
    public static boolean isValidUrl(String urlStr) {
        try {
            URI uri = new URI(urlStr);
            String scheme = uri.getScheme();
            return scheme != null && (scheme.equals("http") || scheme.equals("https"));
        } catch (URISyntaxException e) {
            return false;
        }
    }
}