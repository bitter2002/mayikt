package com.mayikt.servlet;

import com.mayikt.entity.MayiktUserEntity;
import com.mayikt.service.MayiktUserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/exUserName")
public class ExUserNameServlet extends HttpServlet {
    private MayiktUserService mayiktUserService = new MayiktUserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取用户输入的userName参数值
        String userName = req.getParameter("userName");
        //2.调用数据库userName查询用户是否存在
        MayiktUserEntity mayiktUserEntity = mayiktUserService.findByUserName(userName);
        PrintWriter writer = resp.getWriter();
        resp.setHeader("Content-type", "text/html;utf-8");
        if (mayiktUserEntity!=null){
            writer.println("该用户"+userName+"已存在,无法注册");
        }
        writer.close();
    }
}
