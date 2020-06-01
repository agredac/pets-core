package com.wow.petscore.medicalrecord.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;


@Value
@Builder
@AllArgsConstructor
public class Pet {

    private Long id;
    private String owner;
    private String petName;
    private String type;
    private String size;
    private MedicalRecord medicalRecord;


}
