package com.buyzilla.dev.code.service;

import com.buyzilla.dev.code.respository.OrderRepository;
import com.buyzilla.dev.code.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    public ResponseEntity<List<Order>> getOrders() {
        return new ResponseEntity<>(orderRepository.findAll(), HttpStatus.OK);
    }

    public void saveOrders(List<Order> orders) {
        orders.forEach(order -> {

        });
    }
}
