package com.buyzilla.dev.code.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "suppliers")
public class Supplier {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int supplierID;
    private int postalCode;
    private String supplierName, Address, City;
}
