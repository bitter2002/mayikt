package com.mayikt.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class UserEntity {
    private Integer id;
    private String userName;
    private Integer age;

    public UserEntity() {
    }

    //    public UserEntity(Integer id, String userName, Integer age) {
//        this.id = id;
//        this.userName = userName;
//        this.age = age;
//    }
//
//    public UserEntity(String userName, Integer age) {
//        this.userName = userName;
//        this.age = age;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
    public static void main(String[] args) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName("gou");
        userEntity.setAge(20);
        String userName1 = userEntity.getUserName();
        System.out.println(userName1);
        log.info(userName1);
    }
}
