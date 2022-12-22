package com.buyzilla.dev.code.exceptions;

public class ShipperNotFoundException extends RuntimeException{
    public ShipperNotFoundException(String message) {
        super(message);
    }
}
