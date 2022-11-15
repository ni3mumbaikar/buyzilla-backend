package com.example.ecom.demo.exceptions;

public class ProductAlreadyExistException extends Exception {
    public ProductAlreadyExistException(Integer id) {
        super("Product Already Exist with pid : "+id);
    }
}
