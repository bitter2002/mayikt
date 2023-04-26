package com.mayikt.service;

import com.mayikt.service.impl.OrderServiceImpl;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

public class Test01 {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\javaweb");
        //创建cglib回调类
        MayiktMethodInterceptor mayiktMethodInterceptor = new MayiktMethodInterceptor();
        Enhancer enhancer = new Enhancer();
        //设置cglib回调类
        enhancer.setCallback(mayiktMethodInterceptor);
        //cglib底层生成代理类 直接继承目标类
        enhancer.setSuperclass(OrderServiceImpl.class);
        OrderServiceImpl orderServiceImplProxy= (OrderServiceImpl) enhancer.create();
        String result= orderServiceImplProxy.addOrder("mayikt", "123");
        System.out.println(result);
    }
}
