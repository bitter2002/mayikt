package com.mayikt.factory;

import com.mayikt.dao.UserDao;

public class UserDaoFactory {
    public static UserDao getUserDao(){
        return new UserDao();
    }
}
