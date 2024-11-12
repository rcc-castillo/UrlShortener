package com.roadmapsh.urlshortener.common.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class UrlAlreadyExistsException extends RuntimeException {
    private HttpStatus status;
    private String code;

    public UrlAlreadyExistsException(String message) {
        super(message);
        this.status = HttpStatus.CONFLICT;
        this.code = "URL_ALREADY_EXISTS";
    }
}
