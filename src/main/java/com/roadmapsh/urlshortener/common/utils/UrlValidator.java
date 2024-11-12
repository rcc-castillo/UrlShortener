package com.roadmapsh.urlshortener.common.utils;

import java.util.regex.Pattern;

public class UrlValidator {
    private static final String URL_REGEX =
            "^(https?://)" + // protocol
                    "((([a-z\\d]([a-z\\d-]*[a-z\\d])*)\\.?)+[a-z]{2,}|" + // domain name
                    "((\\d{1,3}\\.){3}\\d{1,3}))" + // OR ip (v4) address
                    "(\\:\\d+)?(/[-a-z\\d%_.~+]*)*" + // port and path
                    "(\\?[;&a-z\\d%_.~+=-]*)?" + // query string
                    "(\\#[-a-z\\d_]*)?$"; // fragment locator

    private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX, Pattern.CASE_INSENSITIVE);

    public static boolean isValidUrl(String urlStr) {
        if (urlStr == null) {
            return false;
        }
        return URL_PATTERN.matcher(urlStr).matches();
    }
}