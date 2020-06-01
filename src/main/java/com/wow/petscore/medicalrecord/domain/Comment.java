package com.wow.petscore.medicalrecord.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@AllArgsConstructor
@Builder
public  class Comment {
    private Long id;
    private String description;
    private LocalDateTime date;
}
