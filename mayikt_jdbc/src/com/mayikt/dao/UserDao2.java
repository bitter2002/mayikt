package com.mayikt.dao;

import com.mayikt.entity.UserEntity;
import com.mayikt.utils.JdbcUtils;

import java.sql.*;

public class UserDao2 {
    /*
     * 用户注册
     * */
    public int registerUser(UserEntity userEntity) {
        Connection connection = null;
        Statement statement = null;
        try {
            //2.注册mysql驱动
//            Class.forName("com.mysql.jdbc.Driver");
            connection = JdbcUtils.getConnection();
            connection.setAutoCommit(false);//如果设定的值为false,则开启事务,手动提交的模式为true,自动提交模式
            //4.获取到执行者对象
            statement = connection.createStatement();
            //5.executeUpdate执行sql语句
            String insertUserSql = "INSERT INTO mayikt_users VALUES(null,'" + userEntity.getPhone() + "','" + userEntity.getPwd() + "')";
            System.out.println("insertStudentSql:" + insertUserSql);
            //影响行数
            int result = statement.executeUpdate(insertUserSql);
            connection.commit();//提交事务
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();//回滚事务
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return 0;
        } finally {
            //释放jdbc资源
            JdbcUtils.closeConnection(statement, connection);
        }

    }

    //根据手机号码查询信息
    public UserEntity getByPhoneUser(String phone) {
        //判断用户输入的手机号是否为空
        if (phone == null || phone.length() == 0) {
            return null;
        }
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //2.注册mysql驱动
//            Class.forName("com.mysql.jdbc.Driver");
            connection = JdbcUtils.getConnection();
            //4.获取到执行者对象
            statement = connection.createStatement();
            //5.执行开发者自己编写的sql语句
            String getByPhoneUserSql = "select * from mayikt_users where phone =" + phone;
            System.out.println(getByPhoneUserSql);
            resultSet = statement.executeQuery(getByPhoneUserSql);
            boolean result = resultSet.next();
            if (!result) {
                return null;
            }
            //6.执行sql语句处理操作
            //获取该行数据第一列id
            Long id = resultSet.getLong("id");
            //获取该行数据第二列phone
            String dbPhone = resultSet.getString("phone");
            //获取该行数据第三列pwd
            String dbPwd = resultSet.getString("pwd");
            //将db中查询到数据封装成java对象
            UserEntity userEntity = new UserEntity(id, dbPhone, dbPwd);
            return userEntity;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            //释放jdbc资源
            JdbcUtils.closeConnection(resultSet, statement, connection);
        }
    }

}
