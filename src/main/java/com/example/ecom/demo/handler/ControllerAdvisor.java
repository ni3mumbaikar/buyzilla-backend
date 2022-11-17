package com.example.ecom.demo.handler;

import com.example.ecom.demo.exceptions.CustomerAlreadyExistException;
import com.example.ecom.demo.exceptions.CustomerNotFoundException;
import com.example.ecom.demo.exceptions.ProductAlreadyExistException;
import com.example.ecom.demo.exceptions.ProductNotFoundException;
import org.hsqldb.HsqlException;
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

    @ExceptionHandler(HsqlException.class)
    ResponseEntity<String> HsqlDb(HsqlException hsqlException){
        return new ResponseEntity<>(hsqlException.getMessage(),HttpStatus.BAD_REQUEST);
    }

}
