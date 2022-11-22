package com.example.ecom.demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
