package com.mayikt.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Test02 {
    public static void main(String[] args) throws SQLException {
        //1创建c3p0数据库连接池  读取c3p0-config配置文件中initialPoolSize初始化5个连接保持连接状态
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        for (int i = 1;i<=20;i++){
            Connection connection = comboPooledDataSource.getConnection();//从数据连接池中获取连接
            System.out.println("第"+i+"个"+connection);
            if (i==10){
                connection.close();//释放连接  底层并不是关闭连接,而是归还连接,继续放入数据库连接池被其他用户复用使用
            }
        }
    }
}
