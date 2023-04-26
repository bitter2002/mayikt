package com.mayikt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//开启springmvc
@EnableWebMvc
@Configuration
@ComponentScan("com.mayikt.controller")
public class SpringmvcConfig {

}
