package com.mayikt.test;

import com.mayikt.dao.FlightDao;
import com.mayikt.entity.FlightEntity;

import java.util.Date;

public class Test01 {
    public static void main(String[] args) {
        FlightDao flightDao = new FlightDao();
        FlightEntity flightEntity = new FlightEntity();
        flightEntity.setId(5);
        flightEntity.setFlightId("MT008");
        flightEntity.setCompany("中国南昌航空公司");
        flightEntity.setDepartureAirport("广州白云机场");
        flightEntity.setArriveAirport("上海浦东机场");
        flightEntity.setDepartureTime(new Date());
        flightEntity.setArriveTime(new Date());
        flightEntity.setModel("K001");
        int i = flightDao.updateFlight(flightEntity);
        System.out.println(i);
    }
}
