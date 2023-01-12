package com.buyzilla.dev.code.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
