package com.example.ecom.demo.service;

import com.example.ecom.demo.entity.Product;
import com.example.ecom.demo.exceptions.ProductNotFoundException;
import com.example.ecom.demo.exceptions.ProductAlreadyExistException;
import com.example.ecom.demo.exceptions.SupplierNotFoundException;
import com.example.ecom.demo.respository.ProductRepository;
import com.example.ecom.demo.respository.SuppliersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service //Create Injectable singleton object of service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    SuppliersRepository suppliersRepository;

    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SupplierNotFoundException.class,ProductAlreadyExistException.class})
    public void saveProducts(List<com.example.ecom.demo.vo.Product> products) throws ProductAlreadyExistException, SupplierNotFoundException {
        for (com.example.ecom.demo.vo.Product product : products) {
            if (productRepository.findById(product.getProductID()).isPresent()) {
                throw new ProductAlreadyExistException(product.getProductID());
            }
            productRepository.save(getEntity(product));
        }
    }

    public ResponseEntity<Product> getProductByPid(Integer pid) throws ProductNotFoundException {
        return new ResponseEntity<>(productRepository.findById(pid).orElseThrow(() -> new ProductNotFoundException(pid)), HttpStatus.OK);
    }

    public void updateProducts(List<com.example.ecom.demo.vo.Product> products) throws ProductNotFoundException, SupplierNotFoundException {
        for (com.example.ecom.demo.vo.Product p : products) {
            if (productRepository.findById(p.getProductID()).isEmpty()) {
                throw new ProductNotFoundException(p.getProductID());
            }
            productRepository.save(getEntity(p));
        }
    }

    public Product getEntity(com.example.ecom.demo.vo.Product product) throws SupplierNotFoundException {
        return Product.builder()
                .productName(product.getProductName())
                .productID(product.getProductID())
                .price(product.getPrice())
                .supplier(suppliersRepository.findById(product.getSupplierID()).orElseThrow(()-> new SupplierNotFoundException(product.getSupplierID())))
                .unit(product.getUnit()).build();
    }

    /*public vo.Product getVo(Product product){
        return vo.Product.builder()
                .productID(product.getProductID())
                .productName(product.getProductName())
                .price(product.getPrice())
                .unit(product.getUnit()).build();
    }*/

}
