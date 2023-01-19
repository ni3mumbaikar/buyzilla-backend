package com.buyzilla.dev.code.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;



@Data
@Entity
@Table(name = "OrderDetails_10708461")
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
