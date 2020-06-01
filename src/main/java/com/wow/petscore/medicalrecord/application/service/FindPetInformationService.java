package com.wow.petscore.medicalrecord.application.service;

import com.wow.petscore.common.UseCase;
import com.wow.petscore.medicalrecord.application.port.in.FindPetRecordHistoryUseCase;
import com.wow.petscore.medicalrecord.application.port.out.FindPetById;
import com.wow.petscore.medicalrecord.domain.Pet;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class FindPetInformationService implements FindPetRecordHistoryUseCase {

  private final FindPetById findPetById;

  @Override
  public Pet findPetInformationById(Long id) {

    return findPetById
        .findPetById(id)
        .orElseThrow(
            () ->
                new PetNotFoundException(
                    "Pet_not_exits", String.format("The student <%s> doesn't exist", id)));
  }
}
