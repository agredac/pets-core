package com.wow.petscore.medicalrecord.application.port.in;

import com.wow.petscore.medicalrecord.domain.Pet;

public interface FindPetRecordHistoryUseCase {

    Pet findPetInformationById(Long id);

}
