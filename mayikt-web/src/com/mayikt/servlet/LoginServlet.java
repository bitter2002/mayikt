package com.mayikt.servlet;


import com.mayikt.utils.MayiktJdbcUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取用户提交的参数
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        String userName = req.getParameter("userName");
        if (StringUtils.isEmpty(userName)) {
            writer.println("userName不能为空");
            return;
        }
        String userPwd = req.getParameter("userPwd");
        if (StringUtils.isEmpty(userPwd)) {
            writer.println("userPwd不能为空");
            return;
        }
        //2.使用jdbc查询sql语句
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = MayiktJdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement("select * from mayikt_users where userName=? and userPwd=?");
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, userPwd);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {//如果有返回结果集的
                writer.println(userName + ",恭喜你登录成功");
                return;
            }
            writer.println("账号或密码错误");
        } catch (Exception e) {
            writer.println("系统出现异常");
        } finally {
            //释放资源
            MayiktJdbcUtils.closeConnection(resultSet,preparedStatement,connection);
            if (writer != null) {
                writer.close();
            }
        }

    }
}
