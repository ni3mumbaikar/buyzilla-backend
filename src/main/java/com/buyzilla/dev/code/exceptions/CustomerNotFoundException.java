package com.buyzilla.dev.code.exceptions;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(Integer id) {
        super("No customer found with id : "+id);
    }
}
