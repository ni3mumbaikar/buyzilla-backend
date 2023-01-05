package com.buyzilla.dev.code.service;

import com.buyzilla.dev.code.entity.Customer;
import com.buyzilla.dev.code.entity.OrderDetail;
import com.buyzilla.dev.code.entity.Shipper;
import com.buyzilla.dev.code.exceptions.CustomerNotFoundException;
import com.buyzilla.dev.code.exceptions.ProductNotFoundException;
import com.buyzilla.dev.code.exceptions.ShipperNotFoundException;
import com.buyzilla.dev.code.respository.CustomerRepository;
import com.buyzilla.dev.code.respository.OrderRepository;
import com.buyzilla.dev.code.entity.Order;
import com.buyzilla.dev.code.respository.ShipperRepository;
import com.buyzilla.dev.code.vo.OrderDetailVo;
import com.buyzilla.dev.code.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


@PropertySource("classpath:eng_exceptions.properties")
@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    Environment environment;

    @Autowired
    ShipperRepository shipperRepository;
    public ResponseEntity<List<Order>> getOrders() {
        return new ResponseEntity<>(orderRepository.findAll(), HttpStatus.OK);
    }


    public void saveOrders(OrderVo orderVo) throws ParseException {
        if(customerRepository.findById(orderVo.getCustomerID()).isEmpty())
            throw new CustomerNotFoundException(environment.getProperty("customer_not_found"));
        if(shipperRepository.findById(orderVo.getShipperID()).isEmpty())
            throw new ShipperNotFoundException(environment.getProperty("shipper_not_found"));
        Order order1 = convertToOrders(orderVo);
        orderRepository.save(order1);
    }

    static Order convertToOrders(OrderVo orderVo) throws ParseException{
        Order order = new Order();
        order.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(orderVo.getDate()));
        Customer customers = new Customer();
        customers.setCustomerID(orderVo.getCustomerID());
        order.setCustomer(customers);
        Shipper shippers = new Shipper();
        shippers.setShipperID(orderVo.getShipperID());
        order.setShipper(shippers);
        List<OrderDetail> orderDetails = new ArrayList<>(); // Generics
        for(OrderDetailVo orderDetailsVoVo : orderVo.getOrderDetailVos()){ //for-each
            orderDetails.add(OrderDetailsService.convertToOrderDetail(orderDetailsVoVo));
        }
        order.setOrderDetails(orderDetails);
        return order;
    }

    public List<Order> findByCustomerID(Integer cid){
        return orderRepository.findByCustomerCustomerID(cid);
    }

}
