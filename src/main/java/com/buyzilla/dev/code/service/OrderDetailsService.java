package com.buyzilla.dev.code.service;


import com.buyzilla.dev.code.entity.OrderDetail;
import com.buyzilla.dev.code.entity.Product;
import com.buyzilla.dev.code.exceptions.ProductNotFoundException;
import com.buyzilla.dev.code.respository.ProductRepository;
import com.buyzilla.dev.code.vo.OrderDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

@PropertySource("classpath:eng_exceptions.properties")
public class OrderDetailsService {

    public static OrderDetail convertToOrderDetail(OrderDetailVo orderDetailsVoVo){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProduct(Product.builder()
                .productID(orderDetailsVoVo.getProductID())
                .build());
        orderDetail.setQuantity(orderDetailsVoVo.getQuantity());
        return orderDetail;
    }

}
