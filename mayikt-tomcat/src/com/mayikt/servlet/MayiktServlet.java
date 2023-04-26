//package com.mayikt.servlet;
//
//import jakarta.servlet.*;
//import jakarta.servlet.annotation.WebServlet;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//@WebServlet(urlPatterns = "/mayiktmeite",loadOnStartup = 1)
///*
//* loadOnStartup = -1为负数的情况下,则表达第一次访问到Servlet
//* 才会创建Servlet
//* loadOnStartup = 1为正数的情况下,不用访问,直接会创建好Servlet
//* */
//public class MayiktServlet implements Servlet {
//    public MayiktServlet(){
//        System.out.println("1.我们对象被创建了");
//    }
//    /*
//    * 1.创建Servlet对象
//    * 2.init初始化方法
//    * 3.service方法
//    * 4.destroy tomcat停止时
//    * */
//    @Override
//    public void init(ServletConfig servletConfig) throws ServletException {
//        System.out.println("2.执行到类中init初始化方法,该方法只会在生命周期中,只会执行一次");
//        /*
//        * 初始化代码
//        * */
//    }
//
//    @Override
//    public ServletConfig getServletConfig() {
//        return null;
//    }
//
//    @Override
//    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
//        System.out.println("3.执行到业务逻辑代码service方法,每次请求都会执行到service,内存地址:"+this);
//    }
//
//    @Override
//    public String getServletInfo() {
//        return null;
//    }
//
//    @Override
//    public void destroy() {
//        System.out.println("4.将tomcat停止时,会执行destroy方法,卸载 MayiktServlet");
//    }
//}
