package com.mayikt.service;

import com.mayikt.entity.UserEntity;
import com.mayikt.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserMapper userMapper;

    /*
     * 插入数据到user表中
     * */
    @RequestMapping("/insertUser")
    public String insertUser(String userName, Integer age) {
        int update = jdbcTemplate.update("insert into users values(null,?,?);", userName, age);
        return update > 0 ? "success" : "fail";
    }

    /*
     * mybatis查询
     * */
    @RequestMapping("/mybatisFindById")
    public UserEntity mybatisFindById(Integer id) {
        return userMapper.selectByUserId(id);
    }

    /*
     * mybatis插入
     * */
    @RequestMapping("/mybatisInsert")
    public String mybatisInsert(String userName, Integer age) {
        int i = userMapper.insertUser(userName, age);
        return i > 0 ? "success" : "fail";
    }

    @RequestMapping("/index")
    public String index() {
        return "罗1";
    }

}
