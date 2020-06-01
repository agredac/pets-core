package com.wow.petscore.medicalrecord.adpters.persistence.repository;

import com.wow.petscore.medicalrecord.adpters.persistence.entity.PetJpaEntity;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<PetJpaEntity, Long> {
}
