package com.example.ecom.demo.service;

import com.example.ecom.demo.entity.Product;
import com.example.ecom.demo.respository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
        new ResponseEntity<>(product, HttpStatus.OK);
    }

    public ResponseEntity<Product> getProductByPid(Integer pid) {
//        if (productRepository.findById(pid).isPresent())
        return new ResponseEntity<>(productRepository.findById(pid).get(), HttpStatus.OK);
    }
}
