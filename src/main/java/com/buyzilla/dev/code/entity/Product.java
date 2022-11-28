package com.buyzilla.dev.code.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @ManyToOne
    @JoinColumn(name = "supplierID")
    Supplier supplier;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int productID;
    private int unit, price;
    private String productName;

}
