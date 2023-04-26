package com.mayikt.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servletB")
public class ServletB extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("name");
        PrintWriter writer = resp.getWriter();
        resp.setHeader("Content-type", "text/html;utf-8");
//        if ("mayikt".equals(name)) {
//            System.out.println("servletB正在处理业务逻辑");
//            writer.println("servletB");
//        } else {
//            writer.println("权限不足");
//        }
        System.out.println("servletB正在处理业务逻辑");
        writer.println("servletB");
        writer.close();
        ;
    }
}
