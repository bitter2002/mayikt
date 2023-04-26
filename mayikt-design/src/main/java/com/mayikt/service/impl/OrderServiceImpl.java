package com.mayikt.service.impl;

import com.mayikt.service.OrderService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderServiceImpl implements OrderService {
    @Override
    public String addOrder(String orderName) {
        log.info("<orderName:{}>", orderName);
        return "ok";
    }
}
