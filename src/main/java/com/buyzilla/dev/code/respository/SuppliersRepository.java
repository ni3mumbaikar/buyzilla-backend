package com.buyzilla.dev.code.respository;

import com.buyzilla.dev.code.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuppliersRepository extends JpaRepository<Supplier,Integer> {
}
