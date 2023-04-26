package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(("/getCookie"))
public class GetCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //请求方式获取客户端传递回来的cookie数据
        Cookie[] cookies = req.getCookies();
        for (int i = 0;i<cookies.length;i++){
          Cookie cookie = cookies[i];
            System.out.println(cookie.getName()+","+cookie.getValue());
        }
    }
}
