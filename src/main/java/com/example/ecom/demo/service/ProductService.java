package com.example.ecom.demo.service;

import com.example.ecom.demo.entity.Product;
import com.example.ecom.demo.exceptions.ProductNotFoundException;
import com.example.ecom.demo.exceptions.ResourceAlreadyExistException;
import com.example.ecom.demo.respository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //inject singleton
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);
    }

    public void saveProduct(Product product) throws ResourceAlreadyExistException {
        if (productRepository.findById(product.getProductID()).isPresent()) {
            throw new ResourceAlreadyExistException(product.getProductID());
        }
        productRepository.save(product);
    }

    public ResponseEntity<Product> getProductByPid(Integer pid) throws ProductNotFoundException {
        return new ResponseEntity<>(productRepository.findById(pid).orElseThrow(() -> new ProductNotFoundException(pid)), HttpStatus.OK);
    }

    public void updateProduct(Product p) throws ProductNotFoundException {
        if (productRepository.findById(p.getProductID()).isEmpty()){
            throw new ProductNotFoundException(p.getProductID());
        }
    }
}
