package com.example.ecom.demo.entity;

public class Suppliers {
    private int supplierID,postalCode;
    private String supplierName,Address,City;

    public Suppliers() {
    }

    public Suppliers(int supplierID, int postalCode, String supplierName, String address, String city) {
        this.supplierID = supplierID;
        this.postalCode = postalCode;
        this.supplierName = supplierName;
        Address = address;
        City = city;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }
}
