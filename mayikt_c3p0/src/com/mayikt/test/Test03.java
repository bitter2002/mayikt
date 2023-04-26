package com.mayikt.test;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mayikt.entity.UserEntity;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class Test03 {
    public static void main(String[] args) throws Exception {
        //使用德鲁伊数据库连接池(阿里巴巴官方提供)
        //1.读取到德鲁伊druid.properties配置文件
        Properties properties = new Properties();
        InputStream resourceAsStream = Test03.class.getClassLoader().getResourceAsStream("druid.properties");
       properties.load(resourceAsStream);
        //2.将该读取到的配置文件放入到数据库连接池中
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        //3.通过dataSource获取连接
        Connection connection = dataSource.getConnection();
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
