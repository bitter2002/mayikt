package com.mayikt.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
/*
* 重写了父类中的doGet和doPost方法
* */
@WebServlet("/httpServletDemo03")
public class HttpServletDemo03 extends MayiktHttpServlet{
    @Override
    protected void doGet(HttpServletRequest httpServletRequest) {
        System.out.println("do...Get方法");
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest) {
        System.out.println("do...Post方法");
    }
}
