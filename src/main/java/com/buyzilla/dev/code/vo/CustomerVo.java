package com.buyzilla.dev.code.vo;

import lombok.Getter;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

@Getter
public class CustomerVo {
    int customerID;
    @Digits(integer = 6, fraction = 0)
    int postalCode;
    @NotEmpty
    String customerName;
    @NotEmpty
    String address;
    @NotEmpty
    String city;
    @NotEmpty
    String country;
}

