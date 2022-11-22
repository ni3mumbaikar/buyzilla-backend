package com.example.ecom.demo.vo;

import lombok.Getter;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class Product {
    private int productID;
    @Min(value = 1,message = "minimum 1 Unit is required")
    private int unit;
    @Min(value = 10, message = "Minimum 10 price is required")
    private int price;
    private int supplierID;
    @NotBlank(message = "productName cannot be empty")
    private String productName;
}
