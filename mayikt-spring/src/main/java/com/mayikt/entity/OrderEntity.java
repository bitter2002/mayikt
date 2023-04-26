package com.mayikt.entity;

public class OrderEntity {
    private String orderId;
    private String orderName;

    public OrderEntity(String orderId, String orderName) {
        this.orderId = orderId;
        this.orderName = orderName;
        System.out.println("反射机制执行到有参构造函数"+orderId+":"+orderName);
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "orderId='" + orderId + '\'' +
                ", orderName='" + orderName + '\'' +
                '}';
    }
}
