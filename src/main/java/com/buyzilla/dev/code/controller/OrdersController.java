package com.buyzilla.dev.code.controller;

import com.buyzilla.dev.code.entity.Order;
import com.buyzilla.dev.code.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1/orders")
public class OrdersController {
    @Autowired
    OrderService orderService;

    @GetMapping
    ResponseEntity<List<Order>> getOrders() {
        return orderService.getOrders();
    }

    @PostMapping
    ResponseEntity<String> saveOrders(List<Order> orders) {
        orderService.saveOrders(orders);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
