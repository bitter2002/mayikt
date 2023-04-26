package com.mayikt.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;


@WebServlet("/httpServletDemo04")
public class HttpServletDemo04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求行的数据
        String method = req.getMethod();//获取请求类型 get post
        System.out.println(method);
        String contextPath = req.getContextPath();//获取项目访问路径
        System.out.println(contextPath);
        StringBuffer requestURL = req.getRequestURL();//获取全路径
        System.out.println(requestURL);
        String requestURI = req.getRequestURI();// 获取访问路径
        System.out.println(requestURI);
        String queryString = req.getQueryString();// 获取 URI 统一资源标识符(获取get请求方法地址栏?传递参数)
        System.out.println(queryString);
        //2.获取请求头中的数据
        String header = req.getHeader("User-Agent");//获取客户端版本信息
        System.out.println(header);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求体参数
        BufferedReader reader = req.getReader();//获取字符输入流
        String str = reader.readLine();//获取客户端发送数据给服务器端设定的请求内容
        System.out.println(str);
        reader.close();
    }
}
