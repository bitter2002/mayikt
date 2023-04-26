package com.mayikt.mapper;


import com.mayikt.entity.UserEntity;

import java.util.List;

public interface UserMapper {
    /*
    *调用UserMapper.getByUsers 方法时,自动查找userMapper.xml
    * sql语句的id值与接口方法名称对应
    * */
   List<UserEntity> getByUsers();
}
