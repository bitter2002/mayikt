package com.mayikt.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
@WebServlet("/httpServletDemo02")
public class HttpServletDemo02 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        /*
         * 判断客户端请求的类型get?post!
         * */
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        /*
        * 发送请求的类型
        * */
        String method = httpServletRequest.getMethod();
//        System.out.println("客户端发送请求的类型:"+method);
        if ("GET".equals(method)){
            doGet(httpServletRequest);
        }else if ("POST".equals(method)){
            doPost(httpServletRequest);
        }
    }

    private void doPost(HttpServletRequest httpServletRequest) {
        System.out.println("doPost方法");
    }

    private void doGet(HttpServletRequest httpServletRequest) {
        System.out.println("doGet方法");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
