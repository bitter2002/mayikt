package com.mayikt.servlet;

public class Test01 {
    public static void main(String[] args) {
        String userCode = "Mn";
        String sessionCode = "mN";
        System.out.println(userCode.equals(sessionCode));
        //图形验证码不区分大小写
        System.out.println(userCode.equalsIgnoreCase(sessionCode));
    }
}
