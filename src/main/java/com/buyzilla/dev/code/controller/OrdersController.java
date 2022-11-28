package com.buyzilla.dev.code.controller;

import com.buyzilla.dev.code.entity.Order;
import com.buyzilla.dev.code.exceptions.CustomerNotFoundException;
import com.buyzilla.dev.code.exceptions.ShipperNotFoundException;
import com.buyzilla.dev.code.service.OrderService;
import com.buyzilla.dev.code.util.ValidList;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/api/v1/orders")
@Validated
public class OrdersController {
    @Autowired
    OrderService orderService;

    @GetMapping
    ResponseEntity<List<Order>> getOrders() {
        return orderService.getOrders();
    }

    @PostMapping
    ResponseEntity<String> saveOrders(@RequestBody @Valid com.buyzilla.dev.code.vo.Order order) throws ParseException, CustomerNotFoundException, ShipperNotFoundException {
        System.out.println(order);
        orderService.saveOrders(order);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
