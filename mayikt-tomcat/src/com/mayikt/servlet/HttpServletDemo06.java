package com.mayikt.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet("/httpServletDemo06")
public class HttpServletDemo06 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //直接采用req对象封装好的 key=参数的名称 value=参数名称对应的值
        Map<String, String[]> parameterMap = req.getParameterMap();
        System.out.println(parameterMap);
        for (String key:parameterMap.keySet()) {
            System.out.println("key:"+key);
            String[] value = parameterMap.get(key);
            System.out.println("value:"+value);
        }
        System.out.println("--------------");
        String userName = req.getParameter("userName");
        System.out.println(userName);
        String userPwd = req.getParameter("userPwd");
        System.out.println(userPwd);
    }
}
