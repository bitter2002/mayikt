package com.mayikt.entity;

public class StudentEntity {
    /*
    * 学生对象
    * 在Java中定义数据库实体类层
    * 不建议使用基本数据类型,会使用包装类
    * */
    //学生学号
    private Long id;
    //学生姓名
    private String name;
    //学生年龄
    private Integer age;
    //学生地址
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public StudentEntity(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public StudentEntity(Long id, String name, Integer age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
