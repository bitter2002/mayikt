package com.mayikt.entity;

public class MayiktUserEntity {
    private String userName;
    private Integer age;
    /*
     *
     * ?mayiktUserInfoEntity.address=江西
     * */
    private MayiktUserInfoEntity mayiktUserInfoEntity;

    public MayiktUserEntity(String userName, Integer age) {
        this.userName = userName;
        this.age = age;
    }

    public MayiktUserEntity() {
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

    public MayiktUserInfoEntity getMayiktUserInfoEntity() {
        return mayiktUserInfoEntity;
    }

    public void setMayiktUserInfoEntity(MayiktUserInfoEntity mayiktUserInfoEntity) {
        this.mayiktUserInfoEntity = mayiktUserInfoEntity;
    }

    @Override
    public String toString() {
        return "MayiktUserEntity{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                ", mayiktUserInfoEntity=" + mayiktUserInfoEntity +
                '}';
    }
}
