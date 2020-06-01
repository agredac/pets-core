package com.wow.petscore.medicalrecord.adpters.persistence.repository;

import com.wow.petscore.medicalrecord.adpters.persistence.entity.MedicalRecordJpaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MedicalRecordRepository extends CrudRepository<MedicalRecordJpaEntity, Long> {

  Optional<MedicalRecordJpaEntity> findByPetId(Long id);
}
