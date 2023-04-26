package com.mayikt.test;

import com.mayikt.entity.FlightEntity;
import com.mayikt.service.FlightService;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Test01 {
    public static void main(String[] args) throws IOException {
        FlightService flightService = new FlightService();

//        List<FlightEntity> flightEntities = flightService.getByFlightAll();
//        System.out.println(flightEntities);

//        FlightEntity byIdFlight = flightService.getByIdFlight(1);
//        System.out.println(byIdFlight);

//        FlightEntity flightEntity = new FlightEntity();
//        flightEntity.setCompany("1");
//        flightEntity.setModel("001");
//        flightEntity.setArriveTime(new Date());
//        flightEntity.setDepartureTime(new Date());
//        flightEntity.setDepartureAirport("nc");
//        flightEntity.setArriveAirport("bj");
//        flightEntity.setIsDelete(1);
//        flightEntity.setFlightId("mk001");
//        int result = flightService.insertFlight(flightEntity);
//        System.out.println(result);

//        int i = flightService.deleteByIdFlight(9);
//        System.out.println(i);


//        FlightEntity flightEntity = new FlightEntity();
//        flightEntity.setCompany("1");
//        flightEntity.setModel("001");
//        flightEntity.setArriveTime(new Date());
//        flightEntity.setDepartureTime(new Date());
//        flightEntity.setDepartureAirport("nc");
//        flightEntity.setArriveAirport("bj");
//        flightEntity.setIsDelete(1);
//        flightEntity.setFlightId("mk001");
//        flightEntity.setId(8);
//        int result = flightService.updateFlight(flightEntity);
//        System.out.println(result);

//        HashMap<String, String> stringStringHashMap = new HashMap<>();
//        stringStringHashMap.put("company","中国东方航空");
//        stringStringHashMap.put("departureAirport","广州天河机场");
//        stringStringHashMap.put("arriveAirport","南昌昌北机场");
//        List<FlightEntity> flightEntities = flightService.getByIdFlightParameterMap(stringStringHashMap);
//        System.out.println(flightEntities);

//        List<FlightEntity> flightEntities = flightService.getByIdFlightParameter("中国东方航空", "广州天河机场", "南昌昌北机场");
//        System.out.println(flightEntities);

        FlightEntity flightEntity = new FlightEntity();
        flightEntity.setCompany("中国东方航空");
        flightEntity.setDepartureAirport("广州天河机场");
        flightEntity.setArriveAirport("南昌昌北机场");
        List<FlightEntity> flightEntities = flightService.getByIdFlightPoJo2(flightEntity);
        System.out.println(flightEntities);

    }
}
