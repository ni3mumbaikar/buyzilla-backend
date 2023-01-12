package com.buyzilla.dev.code.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders_10708461")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderID;

    @ManyToOne @JoinColumn(name = "customerID")
    private Customer customer;

    @ManyToOne @JoinColumn(name = "shipperID")
    private Shipper shipper;

    @Temporal(TemporalType.DATE)
    private Date date;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY) @JoinColumn(name = "orderId")
    private List<OrderDetail> orderDetails;

}
