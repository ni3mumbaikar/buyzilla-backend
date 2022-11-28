package com.buyzilla.dev.code.service;


import com.buyzilla.dev.code.entity.OrderDetail;
import com.buyzilla.dev.code.entity.Product;

public class OrderDetailsService {
    public static OrderDetail convertToOrderDetail(com.buyzilla.dev.code.vo.OrderDetail orderDetailsVo) {
        OrderDetail orderDetail = new OrderDetail();
        Product product = new Product();
        product.setProductID(orderDetailsVo.getProductID());
        orderDetail.setProduct(product);
        orderDetail.setQuantity(orderDetailsVo.getQuantity());
        return orderDetail;
    }
}
