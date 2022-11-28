package com.buyzilla.dev.code.exceptions;

public class SupplierNotFoundException extends Exception{
    public SupplierNotFoundException(Integer id) {
        super("No supplier found with id "+id);
    }
}
