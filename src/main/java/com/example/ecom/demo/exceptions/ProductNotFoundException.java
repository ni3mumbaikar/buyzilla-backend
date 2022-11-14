package com.example.ecom.demo.exceptions;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String message) {
        super("No product found with pid "+message);
    }
}
