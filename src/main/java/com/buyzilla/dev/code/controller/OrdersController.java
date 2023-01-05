package com.buyzilla.dev.code.controller;

import com.buyzilla.dev.code.entity.Order;
import com.buyzilla.dev.code.exceptions.CustomerNotFoundException;
import com.buyzilla.dev.code.exceptions.ProductNotFoundException;
import com.buyzilla.dev.code.exceptions.ShipperNotFoundException;
import com.buyzilla.dev.code.service.OrderDetailsService;
import com.buyzilla.dev.code.service.OrderService;
import com.buyzilla.dev.code.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/api/v1/orders")
@Validated
public class OrdersController {
    @Autowired
    OrderService orderService;

    OrderDetailsService orderDetailsService;

    @GetMapping()
    ResponseEntity<List<Order>> getOrders() {
        return orderService.getOrders();
    }

    @PostMapping
    ResponseEntity<String> saveOrders(@RequestBody @Valid OrderVo orderVo) throws ParseException, CustomerNotFoundException, ShipperNotFoundException, ProductNotFoundException {
        System.out.println(orderVo);
        orderService.saveOrders(orderVo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{cid}")
    ResponseEntity<List<Order>> findByCustomerID(@PathVariable Integer cid){
        return ResponseEntity.ok(orderService.findByCustomerID(cid));
    }

}
