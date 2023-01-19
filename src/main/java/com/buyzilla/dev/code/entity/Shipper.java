package com.buyzilla.dev.code.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shippers_10708461")
@Entity
public class Shipper {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer shipperID;

    private Long phone;
    private String shipperName;

}
