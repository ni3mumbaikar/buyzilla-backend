package com.buyzilla.dev.code.util;

//reference : https://stackoverflow.com/questions/28150405/validation-of-a-list-of-objects-in-spring

import jakarta.validation.Valid;
import lombok.Data;
import lombok.experimental.Delegate;


import java.util.ArrayList;
import java.util.List;

@Data
public class ValidList<E> implements List<E> {
    @Valid
    @Delegate
    private List<E> list = new ArrayList<>();
}
