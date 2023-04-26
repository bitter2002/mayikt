package demo01;

import com.mysql.jdbc.Driver;

import java.sql.*;

public class jdbcDemo01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        /*
         * 1.项目中需要引入mysql的驱动jar包
         * 2.注册mysql驱动
         * 3.创建数据库连接
         * 4.获取到执行者对象
         * 5.执行开发者自己编写的sql语句
         * 6.执行sql语句处理操作
         * 7.关闭资源
         * */
        //2.注册mysql驱动
        Class.forName("com.mysql.jdbc.Driver");//反射机制 0
//        DriverManager.registerDriver(new Driver());

        //3.创建数据库连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/b200105?serverTimezone=UTC", "root", "123456");
        //4.获取到执行者对象
        Statement statement = connection.createStatement();
        //5.执行开发者自己编写的sql语句
        ResultSet resultSet = statement.executeQuery("select * from students");
        //6.执行sql语句处理操作
        while (resultSet.next()) {//判断如果有下一行数据,则取出该数据,没有则返回false
            resultSet.getInt("id");
            resultSet.getString("studentid");
            resultSet.getString("name");
            resultSet.getString("sex");
            System.out.println("id:" + resultSet.getInt("id") + "," +
                    "studentid:" + resultSet.getString("studentid") + "," + "name:" + resultSet.getString("name") +
                    "," + "sex:" + resultSet.getString("sex"));
        }
        //7.关闭资源
        connection.close();
        statement.close();
    }
}
