package com.mayikt.entity;

public class MemberEntity {

    private String name;

    public MemberEntity() {
        System.out.println("[第一步流程]:执行MemberEntity无参构造方法");
    }

    public void setName(String name) {
        System.out.println("[第二步流程:]执行setName方法");
        this.name = name;
    }

    public void init() {
        System.out.println("[第三步流程]:执行init方法");
    }

    public void destroy() {
        System.out.println("[第五步流程]:执行destroy方法");
    }
}
