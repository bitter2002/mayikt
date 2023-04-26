package com.mayikt.dao;

import com.mayikt.entity.StudentEntity;
import com.mayikt.utils.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;

public class StudentDao {
    /*
     * 学生对象数据库访问层
     * */
    //查询所有学生信息
    public ArrayList<StudentEntity> allStudent() {
        /*
         * 1.java连接mysql数据库查询所有数据
         * 2.将这些数据存入ArrayList<StudentEntity>
         * */
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //2.注册mysql驱动
//            Class.forName("com.mysql.jdbc.Driver");
            //3.创建数据库连接
             connection = JdbcUtils.getConnection();
            //4.获取到执行者对象
            statement = connection.createStatement();
            //5.执行开发者自己编写的sql语句
            resultSet = statement.executeQuery("select * from mayikt_student");
            ArrayList<StudentEntity> studentEntities = new ArrayList<>();
            //6.执行sql语句处理操作
            while (resultSet.next()) {//判断如果有下一行数据,则取出该数据,没有则返回false
                //获取该行数据第一列id
                Long id = resultSet.getLong("id");
                //获取该行数据第二列name
                String name = resultSet.getString("name");
                //获取该行数据第三列age
                Integer age = resultSet.getInt("age");
                //获取该行数据第四列address
                String address = resultSet.getString("address");
                //将db中查询到数据封装成java对象
                StudentEntity studentEntity = new StudentEntity(id, name, age, address);
                //将该对象存入到集合中
                studentEntities.add(studentEntity);
            }
            return studentEntities;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            //释放jdbc资源
          JdbcUtils.closeConnection(resultSet,statement,connection);
        }
    }
    /*
    * 根据学生id查询学生信息
    * */
    public StudentEntity getByIdStudent(Long stuId){
        if(stuId == null){
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
            resultSet = statement.executeQuery("select * from mayikt_student where id ="+stuId);
            boolean result = resultSet.next();
            if(!result){
                return null;
            }
            //6.执行sql语句处理操作
            //获取该行数据第一列id
            Long id = resultSet.getLong("id");
            //获取该行数据第二列name
            String name = resultSet.getString("name");
            //获取该行数据第三列age
            Integer age = resultSet.getInt("age");
            //获取该行数据第四列address
            String address = resultSet.getString("address");
            //将db中查询到数据封装成java对象
            StudentEntity studentEntity = new StudentEntity(id, name, age, address);
            return studentEntity;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            //释放jdbc资源
           JdbcUtils.closeConnection(resultSet,statement,connection);
        }
    }
    //插入学生
    public int insertStudent(StudentEntity stu){
        Connection connection = null;
        Statement statement = null;
        try {
            //2.注册mysql驱动
//            Class.forName("com.mysql.jdbc.Driver");
            connection = JdbcUtils.getConnection();
            //4.获取到执行者对象
            statement = connection.createStatement();
            //5.executeUpdate执行sql语句
            String insertStudentSql = "INSERT INTO mayikt_student VALUES(NULL,'"+stu.getName()+"',"+stu.getAge()+",'"+stu.getAddress()+"')";
            System.out.println("insertStudentSql:"+insertStudentSql);
            //影响行数
            int result = statement.executeUpdate(insertStudentSql);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            //释放jdbc资源
           JdbcUtils.closeConnection(statement,connection);
        }
    }
    //根据id修改学生信息
    public int updateStudent(StudentEntity stu){
        Connection connection = null;
        Statement statement = null;
        try {
            //2.注册mysql驱动
//            Class.forName("com.mysql.jdbc.Driver");
            //3.创建数据库连接
            connection = JdbcUtils.getConnection();
            //4.获取到执行者对象
            statement = connection.createStatement();
            //5.executeUpdate执行sql语句
            String updateStudentSql = "UPDATE mayikt_student set name = '"+stu.getName()+"',age="+stu.getAge()+",address='"+stu.getAddress()+"' WHERE id="+stu.getId()+"";
            System.out.println("updateStudentSql:"+updateStudentSql);
            //影响行数
            int result = statement.executeUpdate(updateStudentSql);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            //释放jdbc资源
           JdbcUtils.closeConnection(statement,connection);
        }
    }
    //根据主键id删除学生信息
    public int deleteStudent(Long id){
        if (id == null){
            return 0;
        }
        Connection connection = null;
        Statement statement = null;
        try {
            //2.注册mysql驱动
//            Class.forName("com.mysql.jdbc.Driver");
            //3.创建数据库连接
            connection = JdbcUtils.getConnection();
            //4.获取到执行者对象
            statement = connection.createStatement();
            //5.executeUpdate执行sql语句
            String delSql = "DELETE from mayikt_student where id="+id;
            System.out.println("updateStudentSql:"+delSql);
            //影响行数
            int result = statement.executeUpdate(delSql);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            //释放jdbc资源
           JdbcUtils.closeConnection(statement,connection);
        }
    }
}
