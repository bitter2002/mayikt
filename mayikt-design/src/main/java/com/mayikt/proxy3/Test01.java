package com.mayikt.proxy3;

import com.mayikt.service.OrderService;
import com.mayikt.service.impl.OrderServiceImpl;

public class Test01 {
    public static void main(String[] args) {
        //将jdk动态生成的class存放本地
        System.getProperties().put("src.main.java.com.mayikt.proxy3", "true");
        OrderService orderService = new MayiktInvocationHandler(new OrderServiceImpl()).getProxy();//得到代理类
        orderService.addOrder("mayikt");
    }
}
