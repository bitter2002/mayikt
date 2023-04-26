package com.mayikt.service;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MayiktMethodInterceptor implements MethodInterceptor {
    /*
     *参数1:cglib代理类
     *参数2:目标方法
     *参数3:目标方法传递参数
     *参数4:封装代理
     * */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //调用目标方法
        System.out.println("调用目标方法开始");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("调用目标方法结束");
        return result;
    }
}
