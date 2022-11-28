package com.buyzilla.dev.code.respository;


import com.buyzilla.dev.code.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
