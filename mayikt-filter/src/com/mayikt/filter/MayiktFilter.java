package com.mayikt.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/*
 * @WebFilter("/*")拦截所有请求
 * */
public class MayiktFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String name = req.getParameter("name");
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Content-type", "text/html;utf-8");
        PrintWriter writer = response.getWriter();
        if ("mayikt".equals(name)) {
            //正常访问请求
            filterChain.doFilter(req, servletResponse);
            System.out.println("放行之后代码处理");
        } else {
            //提示访问权限不足
            writer.println("权限不足");
        }
        writer.close();
    }
}
