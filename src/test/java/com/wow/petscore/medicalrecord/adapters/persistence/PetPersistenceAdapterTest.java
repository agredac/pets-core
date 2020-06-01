package com.wow.petscore.medicalrecord.adapters.persistence;

import com.wow.petscore.medicalrecord.adpters.persistence.PetByPersistenceAdapter;
import com.wow.petscore.medicalrecord.adpters.persistence.mapper.PetPersistenceMapperImpl;
import com.wow.petscore.medicalrecord.domain.Pet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import({PetByPersistenceAdapter.class, PetPersistenceMapperImpl.class})
class PetPersistenceAdapterTest {

  @Autowired
  PetByPersistenceAdapter adapterUnderTest;

  @Test
  @Sql("test.sql")
  void givenExistingPetId_shouldRetrievePetInfo() {

    Optional<Pet> pet = adapterUnderTest.findPetById(1L);

    assertThat(pet).isPresent();
    assertThat(pet.get()).isNotNull();
  }
}
