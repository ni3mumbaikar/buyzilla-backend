package com.buyzilla.dev.code.service;

import com.buyzilla.dev.code.exceptions.ProductAlreadyExistException;
import com.buyzilla.dev.code.exceptions.ProductNotFoundException;
import com.buyzilla.dev.code.respository.ProductRepository;
import com.buyzilla.dev.code.vo.Product;
import com.buyzilla.dev.code.exceptions.SupplierNotFoundException;
import com.buyzilla.dev.code.respository.SuppliersRepository;
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

    public List<com.buyzilla.dev.code.entity.Product> getProducts() {
        return productRepository.findAll();
    }

    @Transactional(rollbackFor = {SupplierNotFoundException.class, ProductAlreadyExistException.class})
    public void saveProducts(List<Product> products) throws ProductAlreadyExistException, SupplierNotFoundException {
        for (Product product : products) {
            if (productRepository.findById(product.getProductID()).isPresent()) {
                throw new ProductAlreadyExistException(product.getProductID());
            }
            productRepository.save(getEntity(product));
        }
    }

    public com.buyzilla.dev.code.entity.Product getProductByPid(Integer pid) throws ProductNotFoundException {
        return productRepository.findById(pid).orElseThrow(() -> new ProductNotFoundException(pid));
    }

    public void updateProducts(List<Product> products) throws ProductNotFoundException, SupplierNotFoundException {
        for (Product p : products) {
            if (productRepository.findById(p.getProductID()).isEmpty()) {
                throw new ProductNotFoundException(p.getProductID());
            }
            productRepository.save(getEntity(p));
        }
    }

    public com.buyzilla.dev.code.entity.Product getEntity(Product product) throws SupplierNotFoundException {
        return com.buyzilla.dev.code.entity.Product.builder()
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
