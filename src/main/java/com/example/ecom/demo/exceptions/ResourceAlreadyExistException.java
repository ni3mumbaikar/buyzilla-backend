package com.example.ecom.demo.exceptions;

public class ResourceAlreadyExistException extends Exception {
    public ResourceAlreadyExistException(Integer pid) {
        super("Resource Already Exist with pid : "+pid);
    }
}
