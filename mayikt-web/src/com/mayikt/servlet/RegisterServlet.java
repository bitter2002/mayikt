package com.mayikt.servlet;

import com.mayikt.utils.MayiktJdbcUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    /*
     * 用户在前端点击提交按钮
     * 如果在我们insert update delete操作时,加上事务
     * */

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //后端获取前端参数值
        //1.获取前端userName userPwd用户填写的值
        resp.setContentType("text/html;charset=utf-8");
        String userName = req.getParameter("userName");
        String userPwd = req.getParameter("userPwd");
        PrintWriter writer = resp.getWriter();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //2.调用jdbc api在数据库中插入数据
            connection = MayiktJdbcUtils.getConnection();
            //3.需要判断该userName在数据库中是否存在 如果存在 则无法注册
            preparedStatement = connection.prepareStatement("select * from mayikt_users where userName=?");
            preparedStatement.setString(1, userName);
            resultSet = preparedStatement.executeQuery();//触发查询语句
            if (resultSet.next()) {//判断是否有下一行的结果集
                //提示该用户名称已经存在,不能继续重复注册
                writer.println("该用户已存在,无法注册");
                return;
            }
            //如果用户不存在的情况下
            MayiktJdbcUtils.beginTransaction(connection);//开启事务
            String insertSql = "INSERT INTO `mayikt`.`mayikt_users` (`id`, `userName`, `userPwd`) VALUES (null, ?, ?);\n";
            preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, userPwd);
            int result = preparedStatement.executeUpdate();//执行insert sql语句
            String resultStr = result > 0 ? "用户注册成功" : "用户注册失败";
            writer.println(resultStr);
            MayiktJdbcUtils.commitTransaction(connection);//提交事务
        } catch (Exception e) {
            e.printStackTrace();
            //需要回滚事务
            MayiktJdbcUtils.rollBackTransaction(connection);
            writer.println("系统出现异常!");
        } finally {
            MayiktJdbcUtils.closeConnection(resultSet, preparedStatement, connection);
            if (writer != null) {
                writer.close();
            }
        }

    }
}
