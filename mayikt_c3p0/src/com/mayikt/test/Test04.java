package com.mayikt.test;

import com.mayikt.entity.UserEntity;
import com.mayikt.utils.MayiktDataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test04 {
    public static void main(String[] args) throws SQLException {
        Connection connection = MayiktDataSourceUtils.getConnection();
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
       MayiktDataSourceUtils.close(connection,preparedStatement,resultSet);
    }
}
