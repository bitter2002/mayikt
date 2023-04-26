package com.mayikt.mapper;

import com.mayikt.entity.FlightEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FlightMapper {
    /*
     * 查询
     * 1.查询所有
     * 2.根据条件查询
     * 3.动态查询方式
     * */
    List<FlightEntity> getByFlightAll();

    List<FlightEntity> getByFlightAll2();

    FlightEntity getByIdFlight(Integer id);

    /*
     * 插入数据的结果,如果影响行数大于0则插入成功
     * */
    int insertFlight(FlightEntity flightEntity);

    int deleteByIdFlight(Integer id);

    int updateFlight(FlightEntity flightEntity);

    /*
     * 多条件查询  map集合传递参数
     * */
    List<FlightEntity> getByIdFlightParameterMap(Map<String, String> parameterMap);

    List<FlightEntity> getByIdFlightParameter(@Param("company") String company,
                                              @Param("departureAirport") String departureAirport,
                                              @Param("arriveAirport") String arriveAirport);

    List<FlightEntity> getByIdFlightPoJo(FlightEntity flightEntity);

    List<FlightEntity> getByIdFlightPoJo2(FlightEntity flightEntity);
}
