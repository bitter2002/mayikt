package com.mayikt.entity;

public class CourseEntity {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CourseEntity{" +
                "name='" + name + '\'' +
                '}';
    }
}
