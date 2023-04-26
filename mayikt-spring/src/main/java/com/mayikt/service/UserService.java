package com.mayikt.service;

import com.mayikt.dao.UserDao;
import com.mayikt.factory.UserDaoFactory;

public class UserService {
    public void addUser(){
        System.out.println("UserService.addUser");
        UserDao userDao = UserDaoFactory.getUserDao();
        userDao.addUser();
    }

    public static void main(String[] args) {
        new UserService().addUser();
    }
}
