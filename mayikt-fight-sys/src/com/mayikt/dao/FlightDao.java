package com.mayikt.dao;

import com.mayikt.entity.FlightEntity;
import com.mayikt.utils.MayiktJdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlightDao {
    /*
     * 查询所有航班信息
     * */
    public List<FlightEntity> getByAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //1.获取连接
            connection = MayiktJdbcUtils.getConnection();
            //2.获取执行者对象
            preparedStatement = connection.prepareStatement("select * from mayikt_flight");
            resultSet = preparedStatement.executeQuery();
            ArrayList<FlightEntity> flightEntities = new ArrayList<>();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String flightId = resultSet.getString("flight_id");
                String company = resultSet.getString("company");
                String departureAirport = resultSet.getString("departure_airport");
                String arriveAirport = resultSet.getString("arrive_airport");
                Date departureTime = resultSet.getDate("departure_time");
                Date arriveTime = resultSet.getDate("arrive_time");
                String model = resultSet.getString("model");
                Integer isDelete = resultSet.getInt("is_delete");
                FlightEntity flightEntity = new FlightEntity(id, flightId, company, departureAirport, arriveAirport, departureAirport, departureTime, arriveTime, model, isDelete);
                //存入集合中
                flightEntities.add(flightEntity);
            }
            return flightEntities;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            //释放资源
            MayiktJdbcUtils.closeConnection(resultSet, preparedStatement, connection);
        }

    }

    /*
     * 根据主键id删除航班信息
     * update delete inset 要加上事务
     * */
    public int deleteFlightById(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //1.获取连接
            connection = MayiktJdbcUtils.getConnection();
            //开启事务
            MayiktJdbcUtils.beginTransaction(connection);
            //2.获取执行者对象
            preparedStatement = connection.prepareStatement("delete from mayikt_flight where id=?");
            preparedStatement.setInt(1, id);
            int result = preparedStatement.executeUpdate();
            //代码没有问题情况系,提交事务
            MayiktJdbcUtils.commitTransaction(connection);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            //回滚事务
            MayiktJdbcUtils.rollBackTransaction(connection);
            return 0;
        } finally {
            //释放资源
            MayiktJdbcUtils.closeConnection(preparedStatement, connection);
        }
    }

    /*
     * 根据id查询航班信息
     * */
    public FlightEntity getByIdFlight(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //1.获取连接
            connection = MayiktJdbcUtils.getConnection();
            //2.获取执行者对象
            preparedStatement = connection.prepareStatement("select * from mayikt_flight where id=?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                return null;
            }
            //连接到db查询数据
            Integer dbid = resultSet.getInt("id");
            String flightId = resultSet.getString("flight_id");
            String company = resultSet.getString("company");
            String departureAirport = resultSet.getString("departure_airport");
            String arriveAirport = resultSet.getString("arrive_airport");
            Date departureTime = resultSet.getDate("departure_time");
            Date arriveTime = resultSet.getDate("arrive_time");
            String model = resultSet.getString("model");
            Integer isDelete = resultSet.getInt("is_delete");
            FlightEntity flightEntity = new FlightEntity(dbid, flightId, company, departureAirport, arriveAirport, departureAirport, departureTime, arriveTime, model, isDelete);
            return flightEntity;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            //释放资源
            MayiktJdbcUtils.closeConnection(resultSet, preparedStatement, connection);
        }
    }

    /*
    * 逻辑删除语句
    * */
    public int updateDelete(Integer id){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //1.获取连接
            connection = MayiktJdbcUtils.getConnection();
            //开启事务
            MayiktJdbcUtils.beginTransaction(connection);
            //2.获取执行者对象
            preparedStatement = connection.prepareStatement("UPDATE `mayikt`.`mayikt_flight` set 'is_delete'=? where id=?");
            preparedStatement.setInt(1,1);
            preparedStatement.setInt(2,id);
            int result = preparedStatement.executeUpdate();
            //代码没有问题情况系,提交事务
            MayiktJdbcUtils.commitTransaction(connection);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            //回滚事务
            MayiktJdbcUtils.rollBackTransaction(connection);
            return 0;
        } finally {
            //释放资源
            MayiktJdbcUtils.closeConnection(preparedStatement,connection);
        }
    }
    /*
     * 根据主键id修改数据
     * */
    public int updateFlight(FlightEntity flightEntity) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //1.获取连接
            connection = MayiktJdbcUtils.getConnection();
            //开启事务
            MayiktJdbcUtils.beginTransaction(connection);
            //2.获取执行者对象
            preparedStatement = connection.prepareStatement("UPDATE `mayikt`.`mayikt_flight` set `flight_id`=?, `company`=?, `departure_airport`=?, `arrive_airport`=?, `departure_time`=?, `arrive_time`=?, `model`=?, `is_delete`='1' WHERE (`id`=?);\n");
            preparedStatement.setString(1, flightEntity.getFlightId());
            preparedStatement.setString(2, flightEntity.getCompany());
            preparedStatement.setString(3, flightEntity.getDepartureAirport());
            preparedStatement.setString(4, flightEntity.getArriveAirport());
            //date
            //new java.sql.Date(flightEntity.getDepartureTime().getTime())  将java.util.date转化为java.sql.date
            preparedStatement.setDate(5, new java.sql.Date(flightEntity.getDepartureTime().getTime()));
            preparedStatement.setDate(6, new java.sql.Date(flightEntity.getArriveTime().getTime()));
            preparedStatement.setString(7, flightEntity.getModel());
            preparedStatement.setInt(8, flightEntity.getId());
            int result = preparedStatement.executeUpdate();
            //代码没有问题情况系,提交事务
            MayiktJdbcUtils.commitTransaction(connection);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            //回滚事务
            MayiktJdbcUtils.rollBackTransaction(connection);
            return 0;
        } finally {
            //释放资源
            MayiktJdbcUtils.closeConnection(preparedStatement,connection);
        }
    }

    /*
     * 添加数据
     * */
    public int insertFlight(FlightEntity flightEntity){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //1.获取连接
            connection = MayiktJdbcUtils.getConnection();
            //开启事务
            MayiktJdbcUtils.beginTransaction(connection);
            //2.获取执行者对象
            preparedStatement = connection.prepareStatement("INSERT INTO `mayikt`.`mayikt_flight` (`id`, `flight_id`, `company`, `departure_airport`, `arrive_airport`, `departure_time`, `arrive_time`, `model`, `is_delete`) VALUES (null, ?, ?, ?, ?, ?, ?,?, '0');\n");
            preparedStatement.setString(1, flightEntity.getFlightId());
            preparedStatement.setString(2, flightEntity.getCompany());
            preparedStatement.setString(3, flightEntity.getDepartureAirport());
            preparedStatement.setString(4, flightEntity.getArriveAirport());
            //date
            //new java.sql.Date(flightEntity.getDepartureTime().getTime())  将java.util.date转化为java.sql.date
            preparedStatement.setDate(5, new java.sql.Date(flightEntity.getDepartureTime().getTime()));
            preparedStatement.setDate(6, new java.sql.Date(flightEntity.getArriveTime().getTime()));
            preparedStatement.setString(7, flightEntity.getModel());
            int result = preparedStatement.executeUpdate();
            //代码没有问题情况系,提交事务
            MayiktJdbcUtils.commitTransaction(connection);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            //回滚事务
            MayiktJdbcUtils.rollBackTransaction(connection);
            return 0;
        } finally {
            //释放资源
            MayiktJdbcUtils.closeConnection(preparedStatement,connection);
        }
    }

}
