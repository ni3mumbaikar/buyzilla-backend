package com.buyzilla.dev.code.vo;

import jakarta.validation.constraints.NotNull;
import lombok.Data;



@Data
public class OrderDetailVo {
    @NotNull(message = "quantity is required")
    private int quantity;
    @NotNull(message = "ProductVo ID is required")
    private int productID;
}