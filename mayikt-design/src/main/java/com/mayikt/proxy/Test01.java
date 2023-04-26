package com.mayikt.proxy;

import com.mayikt.service.impl.OrderServiceImpl;

public class Test01 {
    public static void main(String[] args) {
        //被代理类--目标类
        OrderServiceProxy orderServiceProxy = new OrderServiceProxy(new OrderServiceImpl());
        String mayikt = orderServiceProxy.addOrder("maykt");
        System.out.println(mayikt);
    }
}
