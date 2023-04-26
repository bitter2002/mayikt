package com.mayikt.mapper;

import com.mayikt.entity.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Insert("INSERT INTO USERS(NAME, AGE) VALUES(#{name}, #{age})")
    int insertUser(@Param("name") String userName, @Param("age") Integer age);

    @Select("select id as id,name as userName,age as age from users where id=#{id}")
    UserEntity selectByUserId(@Param("id") Integer id);
}
