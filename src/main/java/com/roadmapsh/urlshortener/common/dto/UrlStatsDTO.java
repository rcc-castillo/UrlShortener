package com.roadmapsh.urlshortener.common.dto;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
