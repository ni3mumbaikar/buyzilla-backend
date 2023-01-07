package com.buyzilla.dev.code.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Data
@Entity
@Table(name = "OrderDetails")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderDetailId;

    @Min(value = 1, message = "Minimum 1 quantity is required")
    Integer quantity;

    @ManyToOne
    @JoinColumn(name = "productID")
    private Product product;

}
