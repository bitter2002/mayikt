package com.mayikt.test;

import com.mayikt.entity.UserEntity;
import com.mayikt.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test01 {
    public static void main(String[] args) throws IOException {
        ///mybatis-config.xml的目录位置
        String resource = "mybatis-config.xml";
        //1.解析mybatis-config.xml 得到数据库相关配置信息
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //2.创建一个sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.获取到sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        List<UserEntity> userEntityList = sqlSession.selectList("userMapper1.getByUsers", UserEntity.class);
//        System.out.println(userEntityList);

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<UserEntity> users = userMapper.getByUsers();
        System.out.println(users);
        sqlSession.close();

        //面向接口编程方式
    }
}
