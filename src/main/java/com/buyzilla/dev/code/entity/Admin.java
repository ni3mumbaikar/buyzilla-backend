package com.buyzilla.dev.code.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "admin_10708461")
public class Admin {
    @Id
    Integer adminID;

    @Column(unique = true)
    String email;

    @JsonIgnore
    String password;
}
