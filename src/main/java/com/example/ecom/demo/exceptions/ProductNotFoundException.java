package com.example.ecom.demo.exceptions;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(Integer id) {
        super("No product found with id "+id);
    }
}
