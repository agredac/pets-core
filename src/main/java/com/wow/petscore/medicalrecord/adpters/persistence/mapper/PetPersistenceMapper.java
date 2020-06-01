package com.wow.petscore.medicalrecord.adpters.persistence.mapper;

import com.wow.petscore.medicalrecord.adpters.persistence.entity.CommentJPAEntity;
import com.wow.petscore.medicalrecord.adpters.persistence.entity.MedicalRecordJpaEntity;
import com.wow.petscore.medicalrecord.adpters.persistence.entity.PetJpaEntity;
import com.wow.petscore.medicalrecord.adpters.persistence.entity.VaccineJpaEntity;
import com.wow.petscore.medicalrecord.domain.Comment;
import com.wow.petscore.medicalrecord.domain.MedicalRecord;
import com.wow.petscore.medicalrecord.domain.Pet;
import com.wow.petscore.medicalrecord.domain.Vaccine;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PetPersistenceMapper {

  @Mapping(source = "petType", target = "type")
  @Mapping(source = "sizeType", target = "size")
  @Mapping(source = "medicalRecord", target = "medicalRecord")
  Pet petJpaEntityToPet(PetJpaEntity petJpaEntity);


  @InheritInverseConfiguration(name = "petJpaEntityToPet")
  PetJpaEntity petToPetJpa(Pet pet);

  MedicalRecord medicalRecordJpaEntityToMedicalRecord(
      MedicalRecordJpaEntity medicalRecordJpaEntity);

  Vaccine VaccineJpaEntityToVaccine(VaccineJpaEntity vaccineJpaEntity);

  Comment commentJpaEntityToComment(CommentJPAEntity commentJPAEntity);

  @Mapping(target = "pet", ignore = true)
  MedicalRecordJpaEntity MedicalRecordToJpaEntity(MedicalRecord medicalRecord);

  @Mapping(target = "medicalRecord", ignore = true)
  VaccineJpaEntity vaccineToVaccineJpaEntity(Vaccine vaccine);

  @Mapping(target = "medicalRecord", ignore = true)
  CommentJPAEntity commentJPAEntityToComment(Comment comment);

  @Mapping(source = "id", target = "pet.id")
  @Mapping(source = "medicalRecord.id", target = "id")
  @Mapping(source = "medicalRecord.comments", target = "comments")
  @Mapping(source = "medicalRecord.vaccines", target = "vaccines")
  MedicalRecordJpaEntity fromPetToMedicalRecordJpaEntity(Pet pet);
}
