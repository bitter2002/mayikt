package com.mayikt.mybatis;

import com.mayikt.mybatis.exit.MayiktInsert;
import com.mayikt.utils.MayiktJdbcUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class MybatisJdkInvocationHandler implements InvocationHandler {
    private Class mapperClass;

    public MybatisJdkInvocationHandler(Class mapperClass) {
        this.mapperClass = mapperClass;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //1.当我们在调用UserMapper.addUser()
        //2.使用java反射机制获取该方法注解
        MayiktInsert annotation = method.getAnnotation(MayiktInsert.class);
        //3.获取注解中sql语句执行
        String insertSql = annotation.value();
        Connection connection = MayiktJdbcUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
        //4.执行完毕之后返回结果
        return preparedStatement.executeUpdate(insertSql);

    }

    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(mapperClass.getClassLoader(), new Class[]{mapperClass}, this);
    }
}