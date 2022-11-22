package com.example.ecom.demo.handler;

import com.example.ecom.demo.exceptions.*;
import org.hsqldb.HsqlException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor {
    @ExceptionHandler(ProductNotFoundException.class)
    ResponseEntity<String>handleProductNotFound(ProductNotFoundException productNotFoundException){
        return new ResponseEntity<>(productNotFoundException.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductAlreadyExistException.class)
    ResponseEntity<String>productAlreadyExist(ProductAlreadyExistException productAlreadyExistException){
        return new ResponseEntity<>(productAlreadyExistException.getMessage(),HttpStatus.valueOf(403));
    }

    @ExceptionHandler(CustomerAlreadyExistException.class)
    ResponseEntity<String> customerAlreadyExistException(CustomerAlreadyExistException customerAlreadyExistException){
        return new ResponseEntity<>(customerAlreadyExistException.getMessage(),HttpStatus.valueOf(403));
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    ResponseEntity<String> customerNotFound(CustomerNotFoundException customerNotFoundException){
        return new ResponseEntity<>(customerNotFoundException.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SupplierNotFoundException.class)
    ResponseEntity<String> supplierNotFound(SupplierNotFoundException supplierNotFoundException){
        return new ResponseEntity<>(supplierNotFoundException.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<String> methodArgumentNotValid(MethodArgumentNotValidException methodArgumentNotValidException){
        StringBuilder sb = new StringBuilder();
        methodArgumentNotValidException.getFieldErrors().forEach(err-> sb.append(err.getDefaultMessage()).append("\n"));
        return new ResponseEntity<>(sb.toString(),HttpStatus.valueOf(406));
    }

    @ExceptionHandler(HsqlException.class)
    ResponseEntity<String> HsqlDb(HsqlException hsqlException){
        return new ResponseEntity<>(hsqlException.getMessage(),HttpStatus.BAD_REQUEST);
    }

}
