package com.buyzilla.dev.code.controller;

import com.buyzilla.dev.code.exceptions.ProductNotFoundException;
import com.buyzilla.dev.code.vo.ProductVo;
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
    ResponseEntity<String> saveProducts(@RequestBody @Valid ValidList<ProductVo> productVos) throws ProductAlreadyExistException, SupplierNotFoundException {
        productVos.forEach(System.out::println);
        productService.saveProducts(productVos);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    ResponseEntity<String> updateProducts(@RequestBody @Valid ValidList<ProductVo> productVos) throws ProductNotFoundException, SupplierNotFoundException {
        productService.updateProducts(productVos);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{pid}")
    ResponseEntity<HttpStatus> deleteProduct(@PathVariable Integer pid){
        productService.deleteProductById(pid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}



