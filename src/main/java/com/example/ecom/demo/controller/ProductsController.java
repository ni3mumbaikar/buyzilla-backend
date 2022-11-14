package com.example.ecom.demo.controller;

import com.example.ecom.demo.entity.Product;
import com.example.ecom.demo.exceptions.ProductNotFoundException;
import com.example.ecom.demo.exceptions.ResourceAlreadyExistException;
import com.example.ecom.demo.utils.ProductUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductsController {

    // TODO : Handle exceptions from controller advisor

    @GetMapping("/api/v1/products")
    ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<List<Product>>(ProductUtils.getProductsList(), HttpStatus.OK);
    }

    @GetMapping("/api/v1/products/{pid}")
    ResponseEntity<Product> getProductByPid(@PathVariable Integer pid) throws ProductNotFoundException {
        return new ResponseEntity<Product>(ProductUtils.getProductByPid(pid), HttpStatus.OK);
    }

    @PostMapping("/api/v1/products")
    ResponseEntity<String> saveProduct(@Validated @RequestBody List<Product> products) throws ResourceAlreadyExistException, JsonProcessingException {
        for (Product product : products) {
            if (product != null) {
                ProductUtils.saveProduct(product);
            }
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/api/v1/product")
    ResponseEntity<String> updateProducts(@Validated @RequestBody List<Product> products) throws ProductNotFoundException, JsonProcessingException {
        ProductUtils.updateProducts(products);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}



