package com.mayikt.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class MayiktDataSourceUtils {
    private static DataSource dataSource;

    /*
     *工具类,静态方法
     * */
    //将MayiktDataSourceUtils私有化
    private MayiktDataSourceUtils() {

    }

    /*
     * 使用静态代码读取配置文件内容,加载,Druid数据库连接池中
     * */
    static {
        try {
            //读取src目录下的druid.properties
            Properties properties = new Properties();
            InputStream resourceAsStream =
                    MayiktDataSourceUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(resourceAsStream);
            //交给我们的Druid数据库连接池中
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * 封装获取Connection的方法
     * */
    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
    public static void close(Connection connection, Statement statement, ResultSet resultSet){
        if (connection!= null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (statement!=null){
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public static void close(Connection connection, Statement statement){
        close(connection,statement,null);
    }
}
