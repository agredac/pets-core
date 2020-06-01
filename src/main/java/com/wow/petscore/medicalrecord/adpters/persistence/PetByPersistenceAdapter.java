package com.wow.petscore.medicalrecord.adpters.persistence;

import com.wow.petscore.medicalrecord.adpters.persistence.entity.PetJpaEntity;
import com.wow.petscore.medicalrecord.adpters.persistence.mapper.PetPersistenceMapper;
import com.wow.petscore.medicalrecord.adpters.persistence.repository.MedicalRecordRepository;
import com.wow.petscore.medicalrecord.adpters.persistence.repository.PetRepository;
import com.wow.petscore.medicalrecord.application.port.out.FindPetById;
import com.wow.petscore.medicalrecord.domain.Pet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PetByPersistenceAdapter implements FindPetById {

  private final PetRepository petRepository;
  private final PetPersistenceMapper mapper;
  private final MedicalRecordRepository medicalRecordRepository;

  @Override
  public Optional<Pet> findPetById(Long id) {

    Optional<PetJpaEntity> optRecord = petRepository.findById(id);

    if (optRecord.isPresent()) return Optional.of(mapper.petJpaEntityToPet(optRecord.get()));

    return Optional.empty();
  }

}
