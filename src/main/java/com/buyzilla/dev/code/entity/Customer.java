package com.buyzilla.dev.code.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    Integer customerID;
    Integer postalCode;
    String customerName, address, city, country;
    @Column(unique = true)
    String email;
    @JsonIgnore
    String password;
}
