//package com.mayikt.servlet;
//
//import jakarta.servlet.*;
//import jakarta.servlet.annotation.WebServlet;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//@WebServlet("/mayikt")
//public class IndexServlet implements Servlet {
//    /**
//     * tomcat启动完成
//     * 127.0.0.1:8080/项目名称/mayikt 执行 service 通过service方法获取servletRequest、servletResponse
//     */
//    @Override
//    public void init(ServletConfig servletConfig) throws ServletException {
//
//    }
//
//    @Override
//    public ServletConfig getServletConfig() {
//        return null;
//    }
//
//    @Override
//    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
//        System.out.printf("mayikt666");
//        //需要通过servletRequest对象获取的客户端传递参数给服务器端
//        String userName = servletRequest.getParameter("userName");
//        servletResponse.setContentType("text/html;charset=utf-8");
//        PrintWriter writer = servletResponse.getWriter();
//        if("mayikt".equals(userName)){
//            //返回数据ok
//            writer.println("访问成功");
//        }else {
//            //返回数据fail
//            writer.println("无法访问");
//        }
//        writer.close();
//    }
//
//    @Override
//    public String getServletInfo() {
//        return null;
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
