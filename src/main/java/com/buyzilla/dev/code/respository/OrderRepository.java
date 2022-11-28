package com.buyzilla.dev.code.respository;

import com.buyzilla.dev.code.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
