package com.roadmapsh.urlshortener.common.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class InvalidUrlException extends RuntimeException {
    private HttpStatus status;
    private String code;

    public InvalidUrlException(String message) {
        super(message);
        this.status = HttpStatus.BAD_REQUEST;
        this.code = "INVALID_URL";
    }
}

