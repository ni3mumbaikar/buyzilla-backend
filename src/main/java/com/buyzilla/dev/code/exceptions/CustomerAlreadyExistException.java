package com.buyzilla.dev.code.exceptions;

public class CustomerAlreadyExistException extends RuntimeException{
    public CustomerAlreadyExistException(Integer id) {
        super("Customer Already Exist with id : "+ id);
    }
}
