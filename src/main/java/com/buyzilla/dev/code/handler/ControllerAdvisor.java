package com.buyzilla.dev.code.handler;

import com.buyzilla.dev.code.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;

@ControllerAdvice
public class ControllerAdvisor {
    @ExceptionHandler(ProductNotFoundException.class)
    ResponseEntity<String>handleProductNotFound(ProductNotFoundException productNotFoundException){
        return new ResponseEntity<>(productNotFoundException.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ShipperAlreadyExistsException.class)
    ResponseEntity<String>handleShipperAlreadyExists(ShipperAlreadyExistsException shipperAlreadyExistsException){
        return new ResponseEntity<>(shipperAlreadyExistsException.getMessage(),HttpStatus.valueOf(403));
    }

    @ExceptionHandler(ProductAlreadyExistException.class)
    ResponseEntity<String>productAlreadyExist(ProductAlreadyExistException productAlreadyExistException){
        return new ResponseEntity<>(productAlreadyExistException.getMessage(),HttpStatus.valueOf(403));
    }

    @ExceptionHandler(AuthFailedException.class)
    ResponseEntity<String> authenticationFailed(AuthFailedException authFailedException){
        return new ResponseEntity<>(authFailedException.getMessage(),HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(CustomerAlreadyExistException.class)
    ResponseEntity<String> customerAlreadyExistException(CustomerAlreadyExistException customerAlreadyExistException){
        return new ResponseEntity<>(customerAlreadyExistException.getMessage(),HttpStatus.valueOf(403));
    }

    @ExceptionHandler(UserNotFoundException.class)
    ResponseEntity<String> customerNotFound(UserNotFoundException userNotFoundException){
        return new ResponseEntity<>(userNotFoundException.getMessage(),HttpStatus.NOT_FOUND);
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

    @ExceptionHandler(SQLException.class)
    ResponseEntity<String> HsqlDb(SQLException hsqlException){
        return new ResponseEntity<>(hsqlException.getMessage(),HttpStatus.BAD_REQUEST);
    }

}
