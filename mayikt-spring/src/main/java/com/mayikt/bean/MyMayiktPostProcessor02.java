package com.mayikt.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class MyMayiktPostProcessor02 implements BeanPostProcessor, Ordered {
    /*
     *调用init之前处理
     * */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("[MyMayiktPostProcessor02]:后置处理器调用init方法之前执行操作");
        return bean;
    }

    /*
     * 调用init之后处理
     * */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("[MyMayiktPostProcessor02]:后置处理器调用init方法之后执行操作");
        return bean;
    }

    /*
     * order值越小越优先加载
     * */
    @Override
    public int getOrder() {
        return 0;
    }
}
