package com.example.ecom.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "OrderDetails")
public class OrderDetail {
    int quantity;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderDetailId;
    private int orderID, productID;
    @ManyToOne
    @JoinColumn(name = "orderID", insertable = false, updatable = false)
    private Order order;
    @ManyToOne
    @JoinColumn(name = "productID", insertable = false, updatable = false)
    private Product product;

}
