package com.example.ecom.demo.exceptions;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(Integer message) {
        super("No product found with pid "+message);
    }
}
