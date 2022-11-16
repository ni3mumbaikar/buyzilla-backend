package com.example.ecom.demo.controller;

import com.example.ecom.demo.entity.Customer;
import com.example.ecom.demo.exceptions.CustomerAlreadyExistException;
import com.example.ecom.demo.exceptions.CustomerNotFoundException;
import com.example.ecom.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CustomersController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/api/v1/customer")
    ResponseEntity<List<Customer>> getCustomers(){
        return customerService.getCustomers();
    }

    @PostMapping("/api/v1/customer")
    ResponseEntity<String> saveCustomer(@RequestBody @Valid List<Customer> customers) throws CustomerAlreadyExistException {
        customerService.saveCustomer(customers);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/api/v1/customer")
    ResponseEntity<String> updateCustomer(@RequestBody @Valid List<Customer> customers) throws CustomerNotFoundException {
        customerService.updateCustomer(customers);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
