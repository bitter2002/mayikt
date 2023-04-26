package com.mayikt.service;

import com.mayikt.dao.FlightDao;
import com.mayikt.entity.FlightEntity;

import java.util.List;

public class FlightService {
    //业务逻辑层调用数据库访问层获取数据
    private FlightDao flightDao = new FlightDao();

    /*
     * 查询所有航班信息
     * */
    public List<FlightEntity> getByAll() {
        return flightDao.getByAll();
    }
    public int deleteFlightById(Integer id){
       return flightDao.deleteFlightById(id);
    }
    public FlightEntity getByIdFlight(Integer id){
        return flightDao.getByIdFlight(id);
    }
    public int updateFlight(FlightEntity flightEntity){
        return flightDao.updateFlight(flightEntity);
    }
    public int insertFlight(FlightEntity flightEntity){
        return flightDao.insertFlight(flightEntity);
    }
    public int updateDelete(Integer id){
        return flightDao.updateDelete(id);
    }

}
