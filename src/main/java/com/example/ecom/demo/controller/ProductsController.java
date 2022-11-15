package com.example.ecom.demo.controller;

import com.example.ecom.demo.entity.Product;
import com.example.ecom.demo.exceptions.ProductNotFoundException;
import com.example.ecom.demo.exceptions.ResourceAlreadyExistException;
import com.example.ecom.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
public class ProductsController {

    // TODO : Handle exceptions from controller advisor

    @Autowired //inject existing object from registry
    ProductService productService;

    @GetMapping("/api/v1/products")
    ResponseEntity<List<Product>> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/api/v1/products/{pid}")
    ResponseEntity<Product> getProductByPid(@PathVariable Integer pid) throws ProductNotFoundException {
        return productService.getProductByPid(pid);
    }

    @PostMapping("/api/v1/products")
    ResponseEntity<String> saveProduct(@RequestBody @Valid List<Product> products) throws ResourceAlreadyExistException {
        for (Product product : products) {
            productService.saveProduct(product);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/api/v1/product")
    ResponseEntity<String> updateProduct(@RequestBody @Valid List<Product> products) throws ProductNotFoundException {
        for (Product p : products){
            productService.updateProduct(p);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}



