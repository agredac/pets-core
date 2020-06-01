package com.wow.petscore.common;

import com.wow.petscore.medicalrecord.application.service.PetNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(PetNotFoundException.class)
    public ResponseEntity<Object> StudentNotExistErrorHandler(PetNotFoundException e) {


        return new ResponseEntity(e, HttpStatus.NOT_FOUND);
    }

}
