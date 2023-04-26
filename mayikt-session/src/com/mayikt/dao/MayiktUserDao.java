package com.mayikt.dao;

import com.mayikt.entity.MayiktUserEntity;
import com.mayikt.utils.MayiktJdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MayiktUserDao {
    public MayiktUserEntity login(String userName, String userPwd) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = MayiktJdbcUtils.getConnection();
            String loginSql = ("select * from mayikt_users where userName=? and userPwd=?");
            preparedStatement = connection.prepareStatement(loginSql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, userPwd);
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                return null;
            }
            //将db中的数据返回客户端
            Integer id = resultSet.getInt(1);
            String dbUserName = resultSet.getString(2);
            String dbUserPwd = resultSet.getString(3);
            MayiktUserEntity mayiktUserEntity = new MayiktUserEntity(id, dbUserName, dbUserPwd);
            return mayiktUserEntity;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            MayiktJdbcUtils.closeConnection(resultSet, preparedStatement, connection);
        }

    }


    public MayiktUserEntity findByUserName(String userName){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = MayiktJdbcUtils.getConnection();
            String loginSql = ("select * from mayikt_users where userName=?");
            preparedStatement = connection.prepareStatement(loginSql);
            preparedStatement.setString(1, userName);
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                return null;
            }
            //将db中的数据返回客户端
            Integer id = resultSet.getInt(1);
            String dbUserName = resultSet.getString(2);
            String dbUserPwd = resultSet.getString(3);
            MayiktUserEntity mayiktUserEntity = new MayiktUserEntity(id, dbUserName, dbUserPwd);
            return mayiktUserEntity;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            MayiktJdbcUtils.closeConnection(resultSet, preparedStatement, connection);
        }
    }
    public int register(String userName, String userPwd) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = MayiktJdbcUtils.getConnection();
            //加上事务
            MayiktJdbcUtils.beginTransaction(connection);//开启事务
            String insertSql = "INSERT INTO `mayikt`.`mayikt_users` (`id`, `userName`, `userPwd`) VALUES (null, ?,?);\n";
            preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, userPwd);
            int result = preparedStatement.executeUpdate();
            MayiktJdbcUtils.commitTransaction(connection);//提交事务
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            MayiktJdbcUtils.rollBackTransaction(connection);
            return 0;
        }finally {
            MayiktJdbcUtils.closeConnection(preparedStatement,connection);
        }

    }
}
