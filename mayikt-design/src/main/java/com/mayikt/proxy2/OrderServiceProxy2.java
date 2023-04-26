package com.mayikt.proxy2;

import com.mayikt.service.impl.OrderServiceImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderServiceProxy2 extends OrderServiceImpl {
    @Override
    public String addOrder(String orderName) {
        log.info("<在addOrder方法前处理 orderName:{}>",orderName);
        String result = super.addOrder(orderName);
        log.info("<在addOrder方法后处理 orderName:{}>",orderName);
        return result;
    }
/*
* 属于静态代理--开发者需要编写代理类,代码非常冗余
* */

}
