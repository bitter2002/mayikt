package com.mayikt.service.impl;

import com.mayikt.service.OrderService;

public class OrderServiceImpl implements OrderService {
    @Override
    public String addOrder(String orderName, String orderId) {
        System.out.println("orderName:"+orderName+",orderId:"+orderId);
        return orderName + orderId;
    }
}
