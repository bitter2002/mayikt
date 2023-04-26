package com.mayikt.mapper;

import com.mayikt.entity.UserEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {
    /*
     * mybatis 注解方式
     * */
    @Insert("INSERT INTO `mayikt`.`mayikt_users` (`id`, `name`, `age`, `addres`) VALUES (null, #{name}, #{age}, #{addres});\n")
    int insertUser(UserEntity userEntity);

    @Delete("delete from mayikt_users where id=#{id}")
    int deleteById(Integer id);

    @Update("UPDATE `mayikt`.`mayikt_users` SET `name`=#{name}, `age`=#{age}, `addres`=#{addres} WHERE (`id`=#{id});\n")
    int updateUser(UserEntity userEntity);

    @Select("select * from mayikt_users where id=#{id}")
    UserEntity getById(Integer id);
}
