package com.example.ecom.demo.service;

import com.example.ecom.demo.entity.Shipper;
import com.example.ecom.demo.respository.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipperService {

    @Autowired
    ShipperRepository shipperRepository;
    public ResponseEntity<List<Shipper>> getShippers() {
        return new ResponseEntity<>(shipperRepository.findAll(), HttpStatus.OK);
    }
}
