package com.example.ecom.demo.respository;

import com.example.ecom.demo.entity.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipperRepository extends JpaRepository<Shipper, Integer> {
}
