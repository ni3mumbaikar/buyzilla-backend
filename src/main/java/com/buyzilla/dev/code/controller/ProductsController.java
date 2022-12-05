package com.buyzilla.dev.code.controller;

import com.buyzilla.dev.code.exceptions.ProductNotFoundException;
import com.buyzilla.dev.code.vo.Product;
import com.buyzilla.dev.code.exceptions.ProductAlreadyExistException;
import com.buyzilla.dev.code.exceptions.SupplierNotFoundException;
import com.buyzilla.dev.code.service.ProductService;
import com.buyzilla.dev.code.util.ValidList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/products")
public class ProductsController {

    @Autowired //inject existing object from registry
    ProductService productService;

    @GetMapping
    ResponseEntity<List<com.buyzilla.dev.code.entity.Product>> getProducts() {
        return ResponseEntity.ok(productService.getProducts()) ;
    }

    @GetMapping("/{pid}")
    ResponseEntity<com.buyzilla.dev.code.entity.Product> getProductByPid(@PathVariable Integer pid) throws ProductNotFoundException {
        return ResponseEntity.ok(productService.getProductByPid(pid));
    }

    @PostMapping
    ResponseEntity<String> saveProducts(@RequestBody @Valid ValidList<Product> products) throws ProductAlreadyExistException, SupplierNotFoundException {
        productService.saveProducts(products);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    ResponseEntity<String> updateProducts(@RequestBody @Valid ValidList<Product> products) throws ProductNotFoundException, SupplierNotFoundException {
        productService.updateProducts(products);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}



