package com.buyzilla.dev.code.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class OrderDetail {
    @NotNull(message = "quantity is required")
    private int quantity;
    @NotNull(message = "Product ID is required")
    private int productID;
}