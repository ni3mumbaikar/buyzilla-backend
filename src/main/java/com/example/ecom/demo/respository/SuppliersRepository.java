package com.example.ecom.demo.respository;

import com.example.ecom.demo.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuppliersRepository extends JpaRepository<Supplier,Integer> {
}
