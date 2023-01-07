package com.buyzilla.dev.code.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AdminVo {
    Integer id;
    @NotNull
    String email,password;
}
