package com.buyzilla.dev.code.controller;

import com.buyzilla.dev.code.entity.Shipper;
import com.buyzilla.dev.code.service.ShipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpResponse;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/shippers")
public class ShippersController {

    @Autowired
    ShipperService shipperService;

    @GetMapping
    ResponseEntity<List<Shipper>> getShippers(){
        return shipperService.getShippers();
    }

    @DeleteMapping("/{sid}")
    ResponseEntity<String> deleteShipper(@PathVariable Integer sid){
        return ResponseEntity.ok(shipperService.deleteShipper(sid));
    }

}
