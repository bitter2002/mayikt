package com.mayikt.entity;

public class DeptEntity {
    /*
    * 部门名称
    * */
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DeptEntity{" +
                "name='" + name + '\'' +
                '}';
    }
}

