package com.mayikt.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/httpServletDemo08")
public class HttpServletDemo08 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HttpServletDemo08..........");
        PrintWriter writer = resp.getWriter();
        //获取到httpServletDemo07转发到httpServletDemo08的共享数据资源
        String name = (String) req.getAttribute("name");
        writer.println("i am HttpServletDemo08:"+name);
        writer.close();
    }
}
