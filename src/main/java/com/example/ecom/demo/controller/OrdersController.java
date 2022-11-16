package com.example.ecom.demo.controller;

import com.example.ecom.demo.entity.Order;
import com.example.ecom.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class OrdersController {
    @Autowired
    OrderService orderService;

    @GetMapping("/api/v1/order")
    ResponseEntity<List<Order>> getOrders() {
        return orderService.getOrders();
    }

    @PostMapping("/api/v1/order")
    ResponseEntity<String> saveOrders(List<Order> orders) {
        orderService.saveOrders(orders);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
