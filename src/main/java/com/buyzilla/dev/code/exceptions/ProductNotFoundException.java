package com.buyzilla.dev.code.exceptions;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(Integer id) {
        super("No product found with id "+id);
    }
}
