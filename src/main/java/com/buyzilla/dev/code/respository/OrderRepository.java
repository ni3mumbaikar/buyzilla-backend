package com.buyzilla.dev.code.respository;

import com.buyzilla.dev.code.entity.Customer;
import com.buyzilla.dev.code.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByCustomerCustomerID(Integer customerID);
}
