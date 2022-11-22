package com.example.ecom.demo.controller;

import com.example.ecom.demo.entity.Product;
import com.example.ecom.demo.exceptions.ProductNotFoundException;
import com.example.ecom.demo.exceptions.ProductAlreadyExistException;
import com.example.ecom.demo.exceptions.SupplierNotFoundException;
import com.example.ecom.demo.service.ProductService;
import com.example.ecom.demo.util.ValidList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductsController {

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
    ResponseEntity<String> saveProducts(@RequestBody @Valid ValidList<com.example.ecom.demo.vo.Product> products) throws ProductAlreadyExistException, SupplierNotFoundException {
        productService.saveProducts(products);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/api/v1/product")
    ResponseEntity<String> updateProducts(@RequestBody @Valid List<com.example.ecom.demo.vo.Product> products) throws ProductNotFoundException, SupplierNotFoundException {
        productService.updateProducts(products);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}



