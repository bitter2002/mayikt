package com.mayikt.entity;

public class UserEntity {
    /*
    * 用户id
    * */
    private Long id;
    /*
    * 用户手机号码
    * */
    private String phone;
    /*
    * 用户密码
    * */
    private String pwd;

    public UserEntity(Long id, String phone, String pwd) {
        this.id = id;
        this.phone = phone;
        this.pwd = pwd;
    }

    public UserEntity(String phone, String pwd) {
        this.phone = phone;
        this.pwd = pwd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
