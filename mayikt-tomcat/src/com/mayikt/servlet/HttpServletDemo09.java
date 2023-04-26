package com.mayikt.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/httpServletDemo09")
public class HttpServletDemo09 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(this);
        //设置正确状态码和不正确状态码 404/200
        resp.setStatus(200);
        //响应数据给客户端
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();//获取字符流
        writer.println("lyx666");
        writer.close();
    }
}
