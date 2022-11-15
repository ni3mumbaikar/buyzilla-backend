package com.example.ecom.demo.handler;

import com.example.ecom.demo.exceptions.ProductNotFoundException;
import com.example.ecom.demo.exceptions.ResourceAlreadyExistException;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor {
    @ExceptionHandler(ProductNotFoundException.class)
    ResponseEntity<String>handleProductNotFound(ProductNotFoundException productNotFoundException){
        return new ResponseEntity<>(productNotFoundException.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceAlreadyExistException.class)
    ResponseEntity<String>resourceAlreadyExist(ResourceAlreadyExistException resourceAlreadyExistException){
        return new ResponseEntity<>(resourceAlreadyExistException.getMessage(),HttpStatus.valueOf(403));
    }

    @ExceptionHandler(JsonProcessingException.class)
    ResponseEntity<String>jsonException(JsonProcessingException jsonProcessingException){
        return new ResponseEntity<>(jsonProcessingException.getMessage(),HttpStatus.NOT_ACCEPTABLE);
    }
}
