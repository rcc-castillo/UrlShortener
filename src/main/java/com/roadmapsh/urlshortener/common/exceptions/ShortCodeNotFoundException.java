package com.roadmapsh.urlshortener.common.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data
public class ShortCodeNotFoundException extends RuntimeException {
    private HttpStatus status;
    private String code;
    public ShortCodeNotFoundException(String message) {
        super(message);
        this.status = HttpStatus.NOT_FOUND;
        this.code = "SHORT_CODE_NOT_FOUND";
    }
}
