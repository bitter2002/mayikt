package com.mayikt.service;

import com.mayikt.dao.MayiktUserDao;
import com.mayikt.entity.MayiktUserEntity;


public class MayiktUserService {
    private MayiktUserDao mayiktUserDao = new MayiktUserDao();
    public MayiktUserEntity login(String userName, String userPwd){
        return mayiktUserDao.login(userName,userPwd);
    }
    public int register(String userName, String userPwd){
        return mayiktUserDao.register(userName,userPwd);
    }
    public MayiktUserEntity findByUserName(String userName){
        return mayiktUserDao.findByUserName(userName);
    }
}
