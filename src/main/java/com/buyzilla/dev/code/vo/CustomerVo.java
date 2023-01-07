package com.buyzilla.dev.code.vo;

import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

@Getter
@ToString
public class CustomerVo {
    int customerID;
    @Digits(integer = 6, fraction = 0, message = "6 Digit pin code is required")
    int postalCode;
    @NotEmpty(message = "Customer name should not be empty")
    String customerName;
    @NotEmpty(message = "Address should not be empty")
    String address;
    @NotEmpty(message = "City should not be empty")
    String city;
    @NotEmpty(message = "Country should no be empty")
    String country;
    @NotEmpty( message = "Password should not be empty")
    String password;
    @NotEmpty (message = "Email should not be empty")
    String email;
}

