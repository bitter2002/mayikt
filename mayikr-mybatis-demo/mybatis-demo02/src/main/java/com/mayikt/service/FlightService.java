package com.mayikt.service;

import com.mayikt.entity.FlightEntity;
import com.mayikt.mapper.FlightMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class FlightService {
    private FlightMapper flightMapper;
    private SqlSession sqlSession;

    public FlightService() throws IOException {
        /*
         *通过无参构造方法,初始化mybatis得到flightMapper
         * */

        ///mybatis-config.xml的目录位置
        String resource = "mybatis-config.xml";
        //1.解析mybatis-config.xml 得到数据库相关配置信息
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //2.创建一个sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.获取到sqlSession
        sqlSession = sqlSessionFactory.openSession();
        flightMapper = sqlSession.getMapper(FlightMapper.class);
//        sqlSession.close();
    }

    public List<FlightEntity> getByFlightAll() {
        return flightMapper.getByFlightAll2();
    }

    public FlightEntity getByIdFlight(Integer id) {
        return flightMapper.getByIdFlight(id);
    }

    public int insertFlight(FlightEntity flightEntity) {
        int result = flightMapper.insertFlight(flightEntity);
        sqlSession.commit();//提交事务
        return result;
    }

    public int deleteByIdFlight(Integer id) {
        int result = flightMapper.deleteByIdFlight(id);
        sqlSession.commit();//提交事务
        return result;
    }

    public int updateFlight(FlightEntity flightEntity) {
        int result = flightMapper.updateFlight(flightEntity);
        sqlSession.commit();//提交事务
        return result;
    }

    public List<FlightEntity> getByIdFlightParameterMap(Map<String, String> parameterMap) {
        return flightMapper.getByIdFlightParameterMap(parameterMap);
    }

    public List<FlightEntity> getByIdFlightParameter(String company, String departureAirport, String arriveAirport) {
        return flightMapper.getByIdFlightParameter(company, departureAirport, arriveAirport);
    }

    public List<FlightEntity> getByIdFlightPoJo(FlightEntity flightEntity) {
        return flightMapper.getByIdFlightPoJo(flightEntity);
    }

    public List<FlightEntity> getByIdFlightPoJo2(FlightEntity flightEntity) {
        return flightMapper.getByIdFlightPoJo2(flightEntity);
    }
}
