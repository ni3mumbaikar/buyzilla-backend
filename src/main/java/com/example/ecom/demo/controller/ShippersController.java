package com.example.ecom.demo.controller;

import com.example.ecom.demo.entity.Shipper;
import com.example.ecom.demo.service.ShipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShippersController {

    @Autowired
    ShipperService shipperService;

    @GetMapping("/api/v1/shipper")
    ResponseEntity<List<Shipper>> getShippers(){
        return shipperService.getShippers();
    }
}
