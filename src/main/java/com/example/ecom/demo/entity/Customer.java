package com.example.ecom.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    int customerID;
    int postalCode;
    String customerName, address, city, country;
}
