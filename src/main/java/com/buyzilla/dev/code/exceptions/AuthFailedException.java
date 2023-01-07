package com.buyzilla.dev.code.exceptions;

public class AuthFailedException extends RuntimeException{
    public AuthFailedException(String message) {
        super(message);
    }
}
