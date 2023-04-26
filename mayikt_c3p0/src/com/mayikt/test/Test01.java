package com.mayikt.test;

import com.mayikt.entity.UserEntity;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test01 {
    public static void main(String[] args) throws PropertyVetoException, SQLException {
        //1.创建c3p0数据库连接池,通过构造方法的形式指定,没有指定则默认使用default-config连接配置
        //如果有指定,则使用指定配置信息
        ComboPooledDataSource pool = new ComboPooledDataSource("mayikt-otherc3p0");
        //2.设置jdbc连接信息  xml/config.properties/yml
//        pool.setUser("root");//设置账户
//        pool.setPassword("123456");//设置密码
//        pool.setJdbcUrl("jdbc:mysql://localhost:3306/mayikt?serverTimezone=UTC");//设置jdbcurl
//        pool.setDriverClass("com.mysql.jdbc.Driver");//设置加载驱动
        //底层会默认读取c3p0-config.xml
        //3.获取连接对象
        Connection connection = pool.getConnection();
        //4.获取到预编译执行者对象,防止sql注入问题
        PreparedStatement preparedStatement =
                connection.prepareStatement("select * from mayikt_users where id=?");
        //5.设置参数
        preparedStatement.setLong(1,1);
        //6.执行sql语句
        ResultSet resultSet = preparedStatement.executeQuery();
        if (!resultSet.next()) {
            return ;
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
        System.out.println(userEntity);
        resultSet.close();
        connection.close();
    }

}
