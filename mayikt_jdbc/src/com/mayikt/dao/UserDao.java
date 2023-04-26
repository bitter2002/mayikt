package com.mayikt.dao;

import com.mayikt.entity.StudentEntity;
import com.mayikt.entity.UserEntity;
import com.mayikt.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDao {
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
            //4.获取到执行者对象
            statement = connection.createStatement();
            //5.executeUpdate执行sql语句
            String insertUserSql = "INSERT INTO mayikt_users VALUES(null,'" + userEntity.getPhone() + "','" + userEntity.getPwd() + "')";
            System.out.println("insertStudentSql:" + insertUserSql);
            //影响行数
            int result = statement.executeUpdate(insertUserSql);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
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
    //用户登录方法
    public UserEntity login(UserEntity userEntity){
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
            String loginSql = "SELECT *FROM mayikt_users WHERE phone='"+userEntity.getPhone()+"' and pwd='"+userEntity.getPwd()+"'";
            System.out.println(loginSql);
            resultSet = statement.executeQuery(loginSql);
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
            return new UserEntity(id, dbPhone, dbPwd);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            //释放jdbc资源
            JdbcUtils.closeConnection(resultSet, statement, connection);
        }
    }

    /*
    * 解决sql注入攻击问题
    * */
    public UserEntity login2(UserEntity userEntity){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            //2.注册mysql驱动
//            Class.forName("com.mysql.jdbc.Driver");
            connection = JdbcUtils.getConnection();
            //4.获取到执行者对象
            //5.执行开发者自己编写的sql语句
            String loginSql = "select * from mayikt_users where phone=? and pwd=?;";
            //预编译执行者对象
            statement = connection.prepareStatement(loginSql);
            statement.setString(1, userEntity.getPhone());
            statement.setString(2, userEntity.getPwd());
            System.out.println(loginSql);
            resultSet = statement.executeQuery(loginSql);
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
            return new UserEntity(id, dbPhone, dbPwd);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            //释放jdbc资源
            JdbcUtils.closeConnection(resultSet, statement, connection);
        }
    }
}
