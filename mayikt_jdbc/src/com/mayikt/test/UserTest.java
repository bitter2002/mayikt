package com.mayikt.test;

import com.mayikt.entity.UserEntity;
import com.mayikt.service.UserService;

import java.util.Scanner;

public class UserTest {
    private UserService userService = new UserService();

    public static void main(String[] args) {
        UserTest userTest = new UserTest();
        userTest.index();
    }
    public void index(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入数字1,用户注册");
        System.out.println("输入数字2,用户登录");
        int number = scanner.nextInt();
        switch (number){
            case 1:
                registerUser();
                break;
            case 2:
                login();
                break;
        }
    }
    public void registerUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入注册用户的手机号码");
        String phone = scanner.nextLine();
        System.out.println("请输入注册用户的密码");
        String pwd = scanner.nextLine();
        int result = userService.registerUser(new UserEntity(phone,pwd));
        if (result>0){
            System.out.println("用户注册成功");
        }else {
            System.out.println("用户注册失败");
        }
    }
    public void login(){
        //给用户输入的机会有三次
      for (int i =1;i<=3;i++){
          Scanner scanner = new Scanner(System.in);
          System.out.println("请输入用户的手机号码");
          String phone = scanner.nextLine();
          System.out.println("请输入用户的密码");
          String pwd = scanner.nextLine();
          //调用登录业务逻辑方法
          UserEntity dbUserEntity = userService.login(new UserEntity(phone, pwd));
          if (dbUserEntity!=null){
              System.out.println("登录成功");
              return;
          }else {
              System.out.println("用户输入的手机号码或者密码不正确!错误的次数:"+i);
          }
      }
    }
}
