package com.buyzilla.dev.code.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class OrderDetailVo {
    @NotNull(message = "quantity is required")
    private int quantity;
    @NotNull(message = "ProductVo ID is required")
    private int productID;
}