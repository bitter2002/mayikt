package com.mayikt.entity;

public class UserEntity {
    private String userName;
    public void addUser() {
        System.out.println("添加用户");
    }
    //执行无参构造函数
    public UserEntity() {
        System.out.println("使用反射初始化,无参构造函数");
    }
    public UserEntity(Integer id) {
        System.out.println("使用反射初始化,有参构造函数");
    }
}
