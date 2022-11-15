package com.example.ecom.demo.entity;

import javax.persistence.Table;
import java.util.Date;

@Table(name = "orders")
public class Order {
    private int OrderID, CustomerID, shipperID;
    private Date date;

    public Order() {
    }

    public Order(int orderID, int customerID, int shipperID, Date date) {
        OrderID = orderID;
        CustomerID = customerID;
        this.shipperID = shipperID;
        this.date = date;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        OrderID = orderID;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public int getShipperID() {
        return shipperID;
    }

    public void setShipperID(int shipperID) {
        this.shipperID = shipperID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
