package com.wow.petscore.medicalrecord.adpters.persistence;

import com.wow.petscore.medicalrecord.adpters.persistence.entity.MedicalRecordJpaEntity;
import com.wow.petscore.medicalrecord.adpters.persistence.mapper.PetPersistenceMapper;
import com.wow.petscore.medicalrecord.adpters.persistence.repository.MedicalRecordRepository;
import com.wow.petscore.medicalrecord.application.port.out.CreateMedicalRecord;
import com.wow.petscore.medicalrecord.application.port.out.DeleteMedicalRecordById;
import com.wow.petscore.medicalrecord.application.port.out.FindMedicalRecordByPetId;
import com.wow.petscore.medicalrecord.application.port.out.UpdateMedicalRecordByPetId;
import com.wow.petscore.medicalrecord.domain.MedicalRecord;
import com.wow.petscore.medicalrecord.domain.Pet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MedicalRecordPersistenceAdapter
    implements CreateMedicalRecord,
        DeleteMedicalRecordById,
        UpdateMedicalRecordByPetId,
        FindMedicalRecordByPetId {

  private final MedicalRecordRepository medicalRecordRepository;
  private final PetPersistenceMapper mapper;

  @Override
  public void createMedicalRecord(Pet pet) {

    MedicalRecordJpaEntity medicalRecordJpaEntity = new MedicalRecordJpaEntity();

    medicalRecordJpaEntity.setPet(mapper.petToPetJpa(pet));
    medicalRecordJpaEntity.addComments(mapper.commentJPAEntityToComment(pet.getMedicalRecord().getComments().get(0)));
    medicalRecordJpaEntity.addVaccine(mapper.vaccineToVaccineJpaEntity(pet.getMedicalRecord().getVaccines().get(0)));

    medicalRecordRepository.save(medicalRecordJpaEntity);
  }

  @Override
  public void deleteMedicalRecord(Long id) {
    medicalRecordRepository.deleteById(id);
  }


  @Override
  public void updateMedicalRecord(Pet pet) {

    MedicalRecordJpaEntity medicalRecordJpaEntity = mapper.fromPetToMedicalRecordJpaEntity(pet);

    medicalRecordRepository.save(medicalRecordJpaEntity);
  }



  @Override
  public Optional<MedicalRecord> findMedicalRecordByPetId(Long id) {

    Optional<MedicalRecordJpaEntity> medicalRecordOpt = medicalRecordRepository.findByPetId(id);

    if(medicalRecordOpt.isPresent()) return Optional.of( mapper.medicalRecordJpaEntityToMedicalRecord(medicalRecordOpt.get()));
    return Optional.empty();
  }
}
