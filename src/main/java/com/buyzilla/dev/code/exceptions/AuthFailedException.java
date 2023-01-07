package com.buyzilla.dev.code.exceptions;

import org.apache.tomcat.util.json.JSONParser;

public class AuthFailedException extends RuntimeException{
    public AuthFailedException(String message) {
        super( message);

    }
}
