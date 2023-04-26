package com.mayikt.service;

import org.springframework.stereotype.Component;

@Component
public class MayiktServiceImpl implements MayiktService{
    public String addUser(){
//        int j = 1/0;
        System.out.println("addUser");
        return "ok";
    }
    public String addUser(Integer age){
        System.out.println("addUser");
        return "ok";
    }
    public String delUser(){
        System.out.println("delUser");
        return "ok";
    }
    public void updateUser(){
        System.out.println("updateUser");
    }
}
