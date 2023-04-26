package com.mayikt.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;


@WebServlet("/httpServletDemo05")
public class HttpServletDemo05 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();
        String parameterStr = null;
        switch (method) {
            case "GET":
                //get请求方法获取内容
                parameterStr = req.getQueryString();
                break;
            case "POST":
                //根据post请假获取参数
                BufferedReader reader = req.getReader();
                parameterStr = reader.readLine();
                reader.close();
                break;
        }
        //2.根据get或者post请求获取参数内容  userName=lyz&userPwd=123
        String[] split = parameterStr.split("&");
        //index为0  userName=lyz  index为1  userPwd=123
        HashMap<String, String> parameterMap = new HashMap<>();
        for (int i = 0; i < split.length; i++) {
            String[] split1 = split[i].split("=");
            String key = split1[0];
            String value = split1[1];
            parameterMap.put(key, value);
        }
        System.out.println(parameterMap);
        String userName = parameterMap.get("userName");
        String usePwd = parameterMap.get("userPwd");
        System.out.println("useName:" + userName);
        System.out.println("usePwd:" + usePwd);
    }
}
