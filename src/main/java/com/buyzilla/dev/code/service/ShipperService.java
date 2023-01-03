package com.buyzilla.dev.code.service;

import com.buyzilla.dev.code.entity.Shipper;
import com.buyzilla.dev.code.exceptions.ShipperNotFoundException;
import com.buyzilla.dev.code.respository.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@PropertySource("classpath:eng_exceptions.properties")
@Service
public class ShipperService {

    @Autowired
    ShipperRepository shipperRepository;

    @Autowired
    Environment environment;

    public ResponseEntity<List<Shipper>> getShippers() {
        return new ResponseEntity<>(shipperRepository.findAll(), HttpStatus.OK);
    }

    public String deleteShipper(Integer sid) {
        System.out.println(shipperRepository.findById(sid));
        shipperRepository.delete(shipperRepository.findById(sid).orElseThrow(() -> new ShipperNotFoundException(environment.getProperty("shipper_not_found"))));
        return "Shipper deleted";
    }
}
