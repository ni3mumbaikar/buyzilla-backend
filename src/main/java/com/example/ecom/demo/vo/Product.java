package com.example.ecom.demo.vo;

import lombok.Getter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Component
public class Product {
    private int productID, unit, price, supplierID;
    @NotNull(message = "productName Cannot be null")
    @NotBlank(message = "productName cannot be empty")
    private String productName;
}
