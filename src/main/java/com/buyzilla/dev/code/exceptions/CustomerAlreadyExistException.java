package com.buyzilla.dev.code.exceptions;

public class CustomerAlreadyExistException extends RuntimeException{
    public CustomerAlreadyExistException(Integer id) {
        super("CustomerVo Already Exist with id : "+ id);
    }
}
