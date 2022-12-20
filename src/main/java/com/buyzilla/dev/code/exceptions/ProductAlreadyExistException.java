package com.buyzilla.dev.code.exceptions;

public class ProductAlreadyExistException extends RuntimeException {
    public ProductAlreadyExistException(Integer id) {
        super("ProductVo Already Exist with pid : "+id);
    }
}
