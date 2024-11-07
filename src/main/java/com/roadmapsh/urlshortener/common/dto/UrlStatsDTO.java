package com.roadmapsh.urlshortener.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UrlStatsDTO {
    private Long id;
    private String url;
    private String shortCode;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private int accessCount;
}
