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

    @Autowired
    ProductRepository productRepository;

    @Autowired
    Environment environment;

    static ProductRepository pr;
    static
    Environment env;
    @PostConstruct
    void initRepo(){
        pr = productRepository;
        env = environment;
    }

    public static OrderDetail convertToOrderDetail(OrderDetailVo orderDetailsVoVo) throws ProductNotFoundException {
        OrderDetail orderDetail = new OrderDetail();
        Product product = pr.findById(orderDetail.getProduct().getProductID()).orElseThrow(()->new ProductNotFoundException(env.getProperty("product_not_found")));
        orderDetail.setProduct(product);
        orderDetail.setQuantity(orderDetailsVoVo.getQuantity());
        return orderDetail;
    }

}
