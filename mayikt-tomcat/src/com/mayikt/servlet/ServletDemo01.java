package com.mayikt.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servletDemo01")
public class ServletDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req);
        System.out.println(resp);
        //req获取到客户端发送数据给服务器
        String userName = req.getParameter("userName");
        String userPwd = req.getParameter("userPwd");
        //判断用户传递的用户名称和密码
        PrintWriter writer = resp.getWriter();
        if ("lyz".equals(userName) && "123".equals(userPwd)) {
            //服务器处理完数据之后,返回对应的数据给客户端
            resp.setHeader("Content-Type", "text/html;charset=UTF-8");
            writer.write("<html><meta charset=\"utf-8\"><body><h1>恭喜你登录成功,该用户名称是" + userName + "</h1></body></html>");
        } else {
            writer.write("<html><meta charset=\"utf-8\"><body><h1>很遗憾,账号或密码错误</h1></body></html>");
        }
        writer.close();
    }
}
