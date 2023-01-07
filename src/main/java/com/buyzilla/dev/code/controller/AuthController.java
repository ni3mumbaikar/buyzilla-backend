package com.buyzilla.dev.code.controller;

import com.buyzilla.dev.code.entity.Admin;
import com.buyzilla.dev.code.entity.Customer;
import com.buyzilla.dev.code.exceptions.AuthFailedException;
import com.buyzilla.dev.code.exceptions.UserNotFoundException;
import com.buyzilla.dev.code.service.AdminService;
import com.buyzilla.dev.code.service.CustomerService;
import com.buyzilla.dev.code.vo.AdminVo;
import com.buyzilla.dev.code.vo.CustomerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AuthController {
    @Autowired
    CustomerService customerService;
    @Autowired
    AdminService adminService;
    @Autowired
    Environment environment;

    @PostMapping("/api/v1/auth/user")
    ResponseEntity<Customer> validateUser(@RequestBody CustomerVo customerVo){
        Customer customer = customerService.findByEmail(customerVo.getEmail());
        if(customer == null){
            throw new AuthFailedException(environment.getProperty("authentication_failed"));
        }
        if(customer.getEmail().equals(customerVo.getEmail()) && customer.getPassword().equals(customerVo.getPassword())){
            return ResponseEntity.ok(customer);
        }
        throw new AuthFailedException(environment.getProperty("authentication_failed"));

    }

    @PostMapping("/api/v1/auth/admin")
    ResponseEntity<Admin> validateAdmin(@RequestBody AdminVo admin){
        Admin admin1 = adminService.findByEmail(admin.getEmail());
        if(admin1 == null){
            throw new AuthFailedException(environment.getProperty("authentication_failed"));
        }
        if(admin1.getEmail().equals(admin.getEmail()) && admin1.getPassword().equals(admin.getPassword())){
            return ResponseEntity.ok(admin1);
        } else {
            throw new AuthFailedException(environment.getProperty("authentication_failed"));
        }
    }

}
