package com.buyzilla.dev.code.controller;

import com.buyzilla.dev.code.entity.Shipper;
import com.buyzilla.dev.code.service.ShipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class ShippersController {

    @Autowired
    ShipperService shipperService;

    @GetMapping("/api/v1/shippers")
    ResponseEntity<List<Shipper>> getShippers(){
        return shipperService.getShippers();
    }
}
