package com.roadmapsh.urlshortener.common.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDTO {
    private int status;
    private String code;
    private String message;
}
