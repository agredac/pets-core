package com.wow.petscore.medicalrecord.adapters.persistence;

import com.wow.petscore.medicalrecord.adpters.persistence.MedicalRecordPersistenceAdapter;
import com.wow.petscore.medicalrecord.adpters.persistence.PetByPersistenceAdapter;
import com.wow.petscore.medicalrecord.adpters.persistence.mapper.PetPersistenceMapperImpl;
import com.wow.petscore.medicalrecord.domain.Comment;
import com.wow.petscore.medicalrecord.domain.MedicalRecord;
import com.wow.petscore.medicalrecord.domain.Pet;
import com.wow.petscore.medicalrecord.domain.Vaccine;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import({
  MedicalRecordPersistenceAdapter.class,
  PetByPersistenceAdapter.class,
  PetPersistenceMapperImpl.class
})
class MedicalRecordPersistenceAdapterTest {

  @Autowired MedicalRecordPersistenceAdapter adapterUnderTest;


  @Test
  @Sql("test.sql")
  void givenValidPetId_ShouldSaveMedicalRecord() {

    Comment description =
        Comment.builder().date(LocalDateTime.now()).description("First control").build();

    Vaccine vaccine = Vaccine.builder().date(LocalDateTime.now()).number("001").type("Anti rabies vaccine ").build();

    MedicalRecord medicalRecord =
        MedicalRecord.builder().comments(Arrays.asList(description)).vaccines(Arrays.asList(vaccine)).build();

    Pet pet = Pet.builder().id(1L).medicalRecord(medicalRecord).build();

    adapterUnderTest.createMedicalRecord(pet);
    Optional<MedicalRecord> recordOpt = adapterUnderTest.findMedicalRecordByPetId(1L);

    assertThat(recordOpt).isPresent();
    assertThat(recordOpt.get()).isNotNull();
  }
}
