package com.buyzilla.dev.code.service;


import com.buyzilla.dev.code.entity.OrderDetail;
import com.buyzilla.dev.code.entity.Product;
import com.buyzilla.dev.code.exceptions.ProductNotFoundException;
import com.buyzilla.dev.code.respository.ProductRepository;
import com.buyzilla.dev.code.vo.OrderDetailVo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class OrderDetailsService {

    @Autowired
    ProductRepository productRepository;

    static ProductRepository pr;
    @PostConstruct
    void initRepo(){
        pr = productRepository;
    }

    public static OrderDetail convertToOrderDetail(OrderDetailVo orderDetailsVoVo) throws ProductNotFoundException {
        OrderDetail orderDetail = new OrderDetail();
        Product product = pr.findById(orderDetail.getProduct().getProductID()).orElseThrow(()->new ProductNotFoundException(orderDetail.getProduct().getProductID()));
        orderDetail.setProduct(product);
        orderDetail.setQuantity(orderDetailsVoVo.getQuantity());
        return orderDetail;
    }
}
