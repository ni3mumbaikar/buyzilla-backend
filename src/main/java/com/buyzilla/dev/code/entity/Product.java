package com.buyzilla.dev.code.entity;

import lombok.*;

import javax.persistence.*;

@Data
@ToString
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
    @Column(name = "product_image")
    private String productImage;

}
