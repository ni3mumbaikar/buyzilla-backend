package com.example.ecom.demo.entity;

import javax.persistence.Table;

@Table(name = "shippers")
public class Shipper {
    private int shipperID;
    private long phone;
    private String shipperName;

    public Shipper() {
    }

    public Shipper(int shipperID, long phone, String shipperName) {
        this.shipperID = shipperID;
        this.phone = phone;
        this.shipperName = shipperName;
    }

    public int getShipperID() {
        return shipperID;
    }

    public void setShipperID(int shipperID) {
        this.shipperID = shipperID;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getShipperName() {
        return shipperName;
    }

    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }
}
