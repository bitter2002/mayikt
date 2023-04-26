package com.mayikt.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/httpServletDemo07")
public class HttpServletDemo07 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //客户端发送请求过来先到达HttpServletDemo07
        System.out.println("HttpServletDemo07......");
        req.setAttribute("name","mayikt");//设置httpServletDemo07转发到httpServletDemo08数据共享
        //转发到HttpServletDemo08
        req.getRequestDispatcher("/httpServletDemo08").forward(req,resp);
    }
}
