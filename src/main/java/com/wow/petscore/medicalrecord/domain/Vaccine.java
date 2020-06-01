package com.wow.petscore.medicalrecord.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@AllArgsConstructor
@Builder
public  class Vaccine {
    private Long id;
    private String number;
    private String type;
    private LocalDateTime date;
}