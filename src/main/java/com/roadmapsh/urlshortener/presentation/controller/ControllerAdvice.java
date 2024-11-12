package com.roadmapsh.urlshortener.presentation.controller;

import com.roadmapsh.urlshortener.common.dto.ErrorDTO;
import com.roadmapsh.urlshortener.common.exceptions.InvalidUrlException;
import com.roadmapsh.urlshortener.common.exceptions.UrlAlreadyExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(InvalidUrlException.class)
    public ResponseEntity<ErrorDTO> handleInvalidUrlException(InvalidUrlException ex) {
        ErrorDTO error = ErrorDTO.builder()
                .status(ex.getStatus().value())
                .code(ex.getCode())
                .message(ex.getMessage())
                .build();
        return ResponseEntity.status(ex.getStatus()).body(error);
    }

    @ExceptionHandler(UrlAlreadyExistsException.class)
    public ResponseEntity<ErrorDTO> handleUrlAlreadyExistsException(UrlAlreadyExistsException ex) {
        ErrorDTO error = ErrorDTO.builder()
                .status(ex.getStatus().value())
                .code(ex.getCode())
                .message(ex.getMessage())
                .build();
        return ResponseEntity.status(ex.getStatus()).body(error);
    }
}
