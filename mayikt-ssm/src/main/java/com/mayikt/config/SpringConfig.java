package com.mayikt.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
//相当于配置spring.xml文件  @Configuration
@Configuration
@ComponentScan("com.mayikt.service")
//@MapperScan() mybatis扫包范围
@MapperScan("com.mayikt.mapper")
//开启事务
@EnableTransactionManagement
//
@Import({JdbcConfig.class,MybatisConfig.class})//
public class SpringConfig {

}
