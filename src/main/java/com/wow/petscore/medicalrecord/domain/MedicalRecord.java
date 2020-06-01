package com.wow.petscore.medicalrecord.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
@AllArgsConstructor
public class MedicalRecord {

  private Long id;
  private List<Comment> comments;
  private List<Vaccine> vaccines;
}
