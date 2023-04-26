package com.mayikt.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/userListServlet")
public class UserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.定义数据源
        ArrayList<String> userList = new ArrayList<>();
        userList.add("lyz");
        userList.add("lyx");
        userList.add("xlk");
        /*
        * key=userList value
        * */
        req.setAttribute("userList",userList);
        req.getRequestDispatcher("userList.jsp").forward(req,resp);
    }
}
