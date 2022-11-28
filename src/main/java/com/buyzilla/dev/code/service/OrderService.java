package com.buyzilla.dev.code.service;

import com.buyzilla.dev.code.entity.Customer;
import com.buyzilla.dev.code.entity.OrderDetail;
import com.buyzilla.dev.code.entity.Shipper;
import com.buyzilla.dev.code.exceptions.CustomerNotFoundException;
import com.buyzilla.dev.code.exceptions.ShipperNotFoundException;
import com.buyzilla.dev.code.respository.CustomerRepository;
import com.buyzilla.dev.code.respository.OrderRepository;
import com.buyzilla.dev.code.entity.Order;
import com.buyzilla.dev.code.respository.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ShipperRepository shipperRepository;
    public ResponseEntity<List<Order>> getOrders() {
        return new ResponseEntity<>(orderRepository.findAll(), HttpStatus.OK);
    }

    public void saveOrders(com.buyzilla.dev.code.vo.Order order) throws ParseException, CustomerNotFoundException, ShipperNotFoundException {
        Order order1 = convertToOrders(order);
        if(customerRepository.findById(order.getCustomerID()).isEmpty())
            throw new CustomerNotFoundException(order.getCustomerID());
        if(shipperRepository.findById(order.getShipperID()).isEmpty())
            throw new ShipperNotFoundException(order.getShipperID());
        orderRepository.save(order1);
    }

    static Order convertToOrders(com.buyzilla.dev.code.vo.Order orderVo) throws ParseException {
        Order order = new Order();
        order.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(orderVo.getDate()));
        Customer customers = new Customer();
        customers.setCustomerID(orderVo.getCustomerID());
        order.setCustomer(customers);
        Shipper shippers = new Shipper();
        shippers.setShipperID(orderVo.getShipperID());
        order.setShipper(shippers);
        List<OrderDetail> orderDetails = new ArrayList<>(); // Generics
        for(com.buyzilla.dev.code.vo.OrderDetail orderDetailsVo : orderVo.getOrderDetails()){ //for-each
            orderDetails.add(OrderDetailsService.convertToOrderDetail(orderDetailsVo));
        }
        order.setOrderDetails(orderDetails);
        return order;
    }
}
