package com.mayikt.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/count", loadOnStartup = 1)
public class CountServlet implements Servlet {
    private Integer count = 0;

    public CountServlet() {
        System.out.println("CountServlet被创建了");
    }

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
        * 在多线程(多个请求)的情况下,共享到一个全局变量,在做写的操作,会发生线程安全性问题
        * */
        synchronized (this){
            count++;
        }
        PrintWriter writer = servletResponse.getWriter();
        servletResponse.setContentType("text/html;charset=utf-8");
        System.out.println(Thread.currentThread().getName()+",count:"+count);
        writer.println("您是第" + count + "个访问网站.当前servlet地址:"+this);
        writer.close();
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
