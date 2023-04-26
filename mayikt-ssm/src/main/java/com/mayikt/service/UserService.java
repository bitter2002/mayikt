package com.mayikt.service;

import com.mayikt.entity.UserEntity;
import com.mayikt.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public int insertUser(UserEntity userEntity) {
        return userMapper.insertUser(userEntity);
    }

    public int deleteById(Integer id) {
        return userMapper.deleteById(id);
    }

    public int updateUser(UserEntity userEntity) {
        return userMapper.updateUser(userEntity);
    }

    public UserEntity getById(Integer id) {
        return userMapper.getById(id);
    }
}
