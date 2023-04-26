package com.mayikt.service;

import com.mayikt.dao.UserDao;
import com.mayikt.entity.UserEntity;

public class UserService {
    private UserDao userDao = new UserDao();
    public int registerUser(UserEntity userEntity){
    //1.根据手机号码查询该用户是否已经注册过,如果已经注册过,则无法注册
        String phone = userEntity.getPhone();
        UserEntity dbUserEntity = userDao.getByPhoneUser(phone);
        if (dbUserEntity != null){
            System.out.println("该用户手机号码已经在数据库中存在,无法注册");
            return 0;
        }
        //用户不存在,可以注册
        int result = userDao.registerUser(userEntity);
        return result;
    }
    public UserEntity login(UserEntity userEntity){
        return userDao.login(userEntity);
    }
}
