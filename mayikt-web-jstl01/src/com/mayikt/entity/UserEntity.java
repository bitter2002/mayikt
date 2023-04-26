package com.mayikt.entity;

public class UserEntity {
    /*
    * 用户姓名
    * */
    private String userName;
    /*
    * 用户年龄
    * */
    private Integer age;
    /*
    * 用户状态 0未冻结 1冻结
    * */
    private Integer state;

    public UserEntity() {
    }

    public UserEntity(String userName, Integer age, Integer state) {
        this.userName = userName;
        this.age = age;
        this.state = state;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
