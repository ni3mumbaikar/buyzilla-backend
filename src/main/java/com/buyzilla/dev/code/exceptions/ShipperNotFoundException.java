package com.buyzilla.dev.code.exceptions;

public class ShipperNotFoundException extends Exception{
    public ShipperNotFoundException(Integer id){
        super("No shipper found with id : "+id);
    }
}
