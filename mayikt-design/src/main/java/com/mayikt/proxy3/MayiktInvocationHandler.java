package com.mayikt.proxy3;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Slf4j
public class MayiktInvocationHandler implements InvocationHandler {
    /*
     * 目标对象
     * */
    private Object target;

    public MayiktInvocationHandler(Object target) {
        this.target = target;
    }

    /*
     * 参数一:Object proxy jdk自动生成的代理类
     * 参数二:目标对象的接口
     * 参数三:目标对象的接口 需要参数值
     * */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("<该目标方法执行前,...args:{}>",args);
        Object result = method.invoke(target, args);//底层基于java反射机制调用该对象中的方法
        log.info("<该目标方法执行后,...args:{}>",args);
        return result;
    }
    //底层自动生成代理类

    /*
    * 参数1:类加载器,传递目标对象的类加载器
    * 参数2:目标对象实现的接口
    * jdk动态代理底层生成代理类实现该接口
    * */
    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this );
    }
}
