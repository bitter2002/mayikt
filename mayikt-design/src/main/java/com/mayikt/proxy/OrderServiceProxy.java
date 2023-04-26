package com.mayikt.proxy;

import com.mayikt.service.OrderService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderServiceProxy implements OrderService {
    //代理类
    private OrderService orderService;

    public OrderServiceProxy(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public String addOrder(String orderName) {
        log.info("<在>addOrder前处理");
        String result= orderService.addOrder(orderName);//调用到被代理类
        log.info("<在>addOrder后处理");
        return result;
    }
}
