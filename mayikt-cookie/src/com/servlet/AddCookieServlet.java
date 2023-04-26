package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//添加cookie
@WebServlet("/addCookie")
public class AddCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //如果创建Cookie
        Cookie cookie = new Cookie("mayikt", "lyz");
        cookie.setMaxAge(60);//正数值60s过期,该数据持久化存放在硬盘中,在有效期内浏览器关闭数据也不会丢失
        //服务器端就会将cookie数据返回给客户端(浏览器端 保存该cookie信息)
        resp.addCookie(cookie);
    }
}
