package com.wow.petscore.medicalrecord.adpters.controller;

import com.wow.petscore.medicalrecord.application.port.in.FindPetRecordHistoryUseCase;
import com.wow.petscore.medicalrecord.domain.Pet;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FindRecordHistoryController {

    private final FindPetRecordHistoryUseCase findPetRecordHistoryUC;

    @GetMapping(path = "/pet/{id}")
   public Pet findPetHistory(@PathVariable(name = "id") Long id){

      return findPetRecordHistoryUC.findPetInformationById(id);

    }

}
