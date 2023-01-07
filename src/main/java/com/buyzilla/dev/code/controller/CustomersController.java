package com.buyzilla.dev.code.controller;

import com.buyzilla.dev.code.util.ValidList;
import com.buyzilla.dev.code.vo.CustomerVo;
import com.buyzilla.dev.code.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/customers")
public class CustomersController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    ResponseEntity<List<com.buyzilla.dev.code.entity.Customer>> getCustomers(){
        return ResponseEntity.ok(customerService.getCustomers());
    }

    @PostMapping
    ResponseEntity<String> saveCustomer(@RequestBody @Valid ValidList<CustomerVo> customerVos){
        customerService.saveCustomer(customerVos);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    ResponseEntity<String> updateCustomer(@RequestBody @Valid ValidList<CustomerVo> customerVos){
        customerService.updateCustomer(customerVos);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{cid}")
    ResponseEntity<String> deleteCustomer(@PathVariable Integer cid){
        customerService.deleteCustomer(cid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
