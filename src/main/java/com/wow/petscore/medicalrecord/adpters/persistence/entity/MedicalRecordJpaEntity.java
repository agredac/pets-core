package com.wow.petscore.medicalrecord.adpters.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "medical_record")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalRecordJpaEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(fetch = FetchType.EAGER)
  private PetJpaEntity pet;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicalRecord")
  private List<CommentJPAEntity> comments = new ArrayList<>();

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicalRecord")
  private List<VaccineJpaEntity> vaccines = new ArrayList<>();

  public void setPet(PetJpaEntity pet){
    this.pet = pet;
    pet.setMedicalRecord(this);
  }

  public MedicalRecordJpaEntity addComments(CommentJPAEntity commentJPAEntity) {
    commentJPAEntity.setMedicalRecord(this);
    this.comments.add(commentJPAEntity);
    return this;
  }

  public MedicalRecordJpaEntity addVaccine(VaccineJpaEntity vaccineJpaEntity) {
    vaccineJpaEntity.setMedicalRecord(this);
    this.vaccines.add(vaccineJpaEntity);
    return this;
  }
}
